import { Component, OnInit } from '@angular/core';
import { LoginserviceService } from '../loginservice.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-client-other-customer-opeartion',
  templateUrl: './client-other-customer-opeartion.component.html',
  styleUrls: ['./client-other-customer-opeartion.component.css']
})
export class ClientOtherCustomerOpeartionComponent implements OnInit {

  customers: Customer[];
  msg: string;
  successmsg: string;
  message: string;

  constructor(private log: LoginserviceService,private activatedroute: ActivatedRoute,private route: Router) { 
   
  }

  ngOnInit() {
  }

  onEdit() {
    window.scrollTo(0, 0);
  }

  viewAllCustomers() {
    this.log.displayCustomer().subscribe(data => {
      console.log(data);
      this.customers = data.bean;
    });
  }

 viewsingleCustomer(singleCustomerForm){
    this.log.displaySingleCustomer(singleCustomerForm.value).subscribe(
      data=>{
        if(data.statuscode === 201){
          console.log(data);
          this.customers=data.bean;
          this.successmsg='The customer id that you have entered found successfully !!';
          setTimeout(()=>{
            this.successmsg=null;
          },3000)
        }
        else{
           this.msg='The customer id that you have entered does`nt exists !!';
           setTimeout(()=>{
              this.msg=null;
           },3000)
        }
        
      }
    );
 }


  deleteCustomer(customer) {
    this.log.deleteCustomer(customer).subscribe(data => {
      if (data.statuscode === 200) {
        this.customers.splice(this.customers.indexOf(customer),1);
        this.msg='Customer deleted successfully !!';
           this.onEdit();     
        setTimeout(()=>{
            this.msg=null;
        },5000)
      } 
    },err=>{
      console.log(err);   
    }
    );
  }

updateCustomer(customer){
  this.route.navigate(
    [`clientEditCustomer/${customer.customerId}`],
    {queryParams:{customerName: customer.customerName,email: customer.email,postalCode: customer.postalCode,
      streetAddress1: customer.streetAddress1,streetAddress2: customer.streetAddress2,
      telephoneNo: customer.telephoneNo,town: customer.town} ,
    });
 
 }



}
