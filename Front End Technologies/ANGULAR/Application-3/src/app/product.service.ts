import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { observable, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  api = 'http://localhost:8081';
  selectedProductToUpdate: product;

  constructor(private http: HttpClient) { }

  postData(product): Observable<any> {
    return this.http.post<any>(`${this.api}/addproduct`, product);
  }


  getData(): Observable<product[]> {
    return this.http.get<product[]>(`${this.api}/viewallproduct`);
  }

  deleteData(product: product): Observable<any> {
    return this.http.delete<any>(`${this.api}/deleteproduct/${product.id}`);
  }

  updateData(product): Observable<any>{
    return this.http.post<any>(`${this.api}/modifyProduct`, product);
  }

}