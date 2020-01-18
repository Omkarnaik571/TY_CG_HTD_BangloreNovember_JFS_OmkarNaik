import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
@Component({
  selector: 'app-customers',
  templateUrl: './customers.component.html',
  styleUrls: ['./customers.component.css']
})
export class CustomersComponent implements OnInit {

customer: CustomersDetails[];

  constructor(private http: HttpClient) {
     this.dataForCustomers();
   }

  ngOnInit() {
  }


  dataForCustomers(){
    this.http.get<CustomersDetails[]>('../../assets/customers.json').subscribe(
       data=>{
         console.log(data);
         this.customer=data;
       }
    );
  }

}

interface CustomersDetails{
   name: string;
   email : string;
   phone : string;
}