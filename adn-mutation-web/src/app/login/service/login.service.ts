import { HttpClient, HttpHeaders } from '@angular/common/http'
import { Observable, Observer, Subscriber } from 'rxjs'
import { LOGIN_URL } from 'src/app/shared/url.constants'
import { Injectable } from '@angular/core';

@Injectable()
export class LoginService {
  private static readonly HEADERS = new HttpHeaders({
    'Content-Type': 'application/json',
  })

  constructor(private http: HttpClient) { }

  login(username: string, password: string): Observable<any> {
    const body = {
      username: username,
      password: password
    }

    const requestOptions = {
      headers: LoginService.HEADERS
    }

    let resultObserver: Subscriber<number>
    let resultObservable = new Observable<number>(
      (observer) => (resultObserver = observer)
    )
    this.http.post(LOGIN_URL, body, requestOptions).subscribe(response => 
      {
        resultObserver.next(200)
        resultObserver.complete()
      },
        error => {
          resultObserver.next(error.status)
          resultObserver.complete()
        }
      )
      return resultObservable;
  }


}
