import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginserviceService {

  

  dburl='http://localhost:8081';

  constructor(private http: HttpClient) { }

  login(loginform): Observable<any> {
    return this.http.post<any>(`${this.dburl}/userAuthentication`, loginform);
  }

  signUp(signUpForm): Observable<any> {
      return this.http.post<any>(`${this.dburl}/addClient`, signUpForm);
  }

  displayAccounts(): Observable<any> {
    return this.http.get(`${this.dburl}/viewallUsers`);
  }

  deleteAccount(account): Observable<any> {
    return this.http.post<any>(`${this.dburl}/deleteUser`,account);
  }

  updateAccount(account):Observable<any>{
    return this.http.put<any>(`${this.dburl}/modifyUser`, account);
  }

 //  Contracts method start
 addContractDetails(contractDetails): Observable<any> {
   return this.http.post<any>(`${this.dburl}/addContract`, contractDetails);
 }

 displayContract(): Observable<any> {
   return this.http.get(`${this.dburl}/viewallContract`);
 }

 displaySingleContract(contractDetails): Observable<any> {
  return this.http.post(`${this.dburl}/viewSingleContract`, contractDetails);
}

 deleteContract(contract: contract): Observable<any> {
   return this.http.delete<any>(`${this.dburl}/deleteContract/${contract.contractNo}`);
 }

  updateContract(contract):Observable<any>{
    return this.http.put<any>(`${this.dburl}/modifyContract`, contract);
  }

 
 //  Contracts method end

 //  Customer methods start
 addCustomerDetails(customerDetails): Observable<any> {
   return this.http.post<any>(`${this.dburl}/addCustomer`, customerDetails);
 }

 displayCustomer(): Observable<any> {
   return this.http.get(`${this.dburl}/viewallCustomer`);
 }

 displaySingleCustomer(customerDetails): Observable<any> {
  return this.http.post(`${this.dburl}/viewSingleCustomer`, customerDetails);
}

 deleteCustomer(customer: Customer): Observable<any> {
  return this.http.delete<any>(`${this.dburl}/deleteCustomer/${customer.customerId}`);
}

updateCustomer(customer):Observable<any>{
  return this.http.put<any>(`${this.dburl}/modifyCustomer`, customer);
}
 // customer methods end

 //Products method begin
 addProductDetails(productDetails): Observable<any> {
  return this.http.post<any>(`${this.dburl}/addProduct`, productDetails);
}

displayProduct(): Observable<any> {
  return this.http.get(`${this.dburl}/viewallProduct`);
}

deleteProduct(product: ProductDetails): Observable<any> {
 return this.http.delete<any>(`${this.dburl}/deleteProduct/${product.productId}`);
}

updateProduct(product):Observable<any>{
 return this.http.put<any>(`${this.dburl}/modifyProduct`, product);
}

 //Products method end
 
 addLandDetails(landDetails): Observable<any> {
  return this.http.post<any>(`${this.dburl}/addLand`, landDetails);
}

displayLand(): Observable<any> {
  return this.http.get(`${this.dburl}/viewallLand`);
}

deleteLand(land: LandDetails): Observable<any> {
 return this.http.delete<any>(`${this.dburl}/deleteLand/${land.plotNumber}`);
}

updateLand(land):Observable<any>{
 return this.http.put<any>(`${this.dburl}/modifyLand`, land);
}



 //Land methods begin


 //land methods end
}
