import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment.development';

@Injectable({
  providedIn: 'root'
})
export class StudyUserSvcService {

  private serviceUrl = `${environment.serviceMainUrl}/user`

  constructor(private http: HttpClient) { }

  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  };

  hello() {
    return this.http.get<Map<String, String>>(this.serviceUrl, this.httpOptions)
  }
}
