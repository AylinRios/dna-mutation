import { HttpClient, HttpHeaders } from '@angular/common/http'
import { Observable } from 'rxjs'
import { Injectable } from '@angular/core';
import { GET_RECORDS, GET_RECORDS_WITH_MUTATION } from 'src/app/shared/url.constants';
import { GenericService } from 'src/app/shared/generic.service';
import { MutationDTO } from 'src/app/shared/model/mutation.model';
import { environment } from 'src/environments/environment.prod';

@Injectable()
export class HomeService {
    private static readonly HEADERS = new HttpHeaders({
        'Content-Type': 'application/json',
    })

    constructor(private genericService: GenericService, private http: HttpClient) { }

    getAll(): Observable<MutationDTO> {
        return this.genericService.retrieve(
            GET_RECORDS
        )
    }

    getRecordsWithMutation(hasMutation: boolean) {
        return this.http.get(`${environment.firebaseConfig.apiBaseUrl}/dna/records-mutated-onmutated/${hasMutation}`);
    }

    getStats() {
        return this.http.get(`${environment.firebaseConfig.apiBaseUrl}/dna/stats`);
    }

    createHuman(name: string) {
        return this.http.post(`${environment.firebaseConfig.apiBaseUrl}/human/${name}`, name)
    }
}