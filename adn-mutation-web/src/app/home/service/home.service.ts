import { HttpClient, HttpHeaders } from '@angular/common/http'
import { Observable } from 'rxjs'
import { Injectable } from '@angular/core';
import { GET_RECORDS, GET_RECORDS_WITH_MUTATION } from 'src/app/shared/url.constants';
import { GenericService } from 'src/app/shared/generic.service';
import { MutationDTO } from 'src/app/shared/model/mutation.model';
import { ResponseDTO } from 'src/app/shared/model/response.model';
import { environment } from 'src/environments/environment';
import { StastDTO } from 'src/app/shared/model/stats.model';

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
        return this.http.get(`${environment.apiBaseUrl}/dna/records-mutated-onmutated/${hasMutation}`);
    }

    getStats() {
        return this.http.get(`${environment.apiBaseUrl}/dna/stats`);
    }

    createHuman(name: string) {
        return this.http.post(`${environment.apiBaseUrl}/human/${name}`, name)
    }
}