import { Component, OnInit } from '@angular/core';
import { LoginserviceService } from '../loginservice.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-other-customer-operation',
  templateUrl: './other-customer-operation.component.html',
  styleUrls: ['./other-customer-operation.component.css']
})
export class OtherCustomerOperationComponent implements OnInit {

  customers: Customer[];
  msg: string;
  successmsg: string;
  message: string;

  constructor(private log: LoginserviceService,private activatedroute: ActivatedRoute,private route: Router) {
    this.viewAllCustomers();
   }

  ngOnInit() {
  }


  viewAllCustomers() {
    this.log.displayCustomer().subscribe(data => {
      console.log(data);
      this.customers = data.bean;
    });
  }


  deleteCustomer(customer) {
    this.log.deleteCustomer(customer).subscribe(data => {
      if (data.statuscode === 200) {
        this.customers.splice(this.customers.indexOf(customer),1);
        this.message='Customer deleted successfully !!';
        setTimeout(()=>{
            this.message=null;
        },5000)
      } 
    },err=>{
      console.log(err);   
    }
    );
  }
deleteMessage(){
  this.message=null;
}

updateCustomer(customer){
  this.route.navigate(
    [`editCustomer/${customer.customerId}`],
    {queryParams:{customerName: customer.customerName,email: customer.email,postalCode: customer.postalCode,
      streetAddress1: customer.streetAddress1,streetAddress2: customer.streetAddress2,
      telephoneNo: customer.telephoneNo,town: customer.town} ,
    });
 
 }


}
