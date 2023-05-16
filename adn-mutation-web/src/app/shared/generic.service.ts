import {
  HttpClient,
  HttpHeaders,
  HttpParams,
  HttpResponse
} from '@angular/common/http'
import { Injectable } from '@angular/core'
import { Observable } from 'rxjs'
import { map } from 'rxjs/operators'



@Injectable()
export class GenericService {
  constructor(private http: HttpClient) { }

  public retrieve<T>(url: string): Observable<T> {
    return this.http.get(url).pipe(
      map((response: any) => {
        return response
      })
    )
  }

}
