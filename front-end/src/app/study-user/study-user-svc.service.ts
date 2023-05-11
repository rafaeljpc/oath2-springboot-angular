import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AuthService } from '@auth0/auth0-angular';
import { concatMap, map } from 'rxjs';
import { environment } from 'src/environments/environment.development';

@Injectable({
  providedIn: 'root'
})
export class StudyUserSvcService {

  private serviceUrl = `${environment.serviceMainUrl}/user`

  constructor(public auth: AuthService, private http: HttpClient) { }

  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  hello() {

    return this.auth.user$.pipe(
      concatMap(
        (user) => this.http.get<Message>(encodeURI(`${this.serviceUrl}/hello`), this.httpOptions)
      )
    )
  }
}

export class Message {
  public message = ""
}