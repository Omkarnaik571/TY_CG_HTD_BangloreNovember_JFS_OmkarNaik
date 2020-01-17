import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';


@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  url = 'http://localhost:8081';

  constructor(private http: HttpClient) { }

  registerUser(userDetails): Observable<any> {
    return this.http.post<any>(`${this.url}/registerUser`, userDetails);
  }


  loginUser(userCredentials): Observable<any> {
    return this.http.post(`${this.url}/loginUser`, userCredentials);
  }

  





}
