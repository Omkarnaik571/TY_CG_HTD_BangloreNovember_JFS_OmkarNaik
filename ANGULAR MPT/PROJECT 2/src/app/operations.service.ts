import { Injectable } from '@angular/core';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OperationsService {



  constructor(private http: HttpClient) { }

   getDetails():Observable<details[]>{
     return this.http.get<details[]>('https://jsonplaceholder.typicode.com/posts');
   }



}
