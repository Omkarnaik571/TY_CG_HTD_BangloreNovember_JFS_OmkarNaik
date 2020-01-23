import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { LoginserviceService } from '../loginservice.service';

@Component({
  selector: 'app-client-edit-customer',
  templateUrl: './client-edit-customer.component.html',
  styleUrls: ['./client-edit-customer.component.css']
})
export class ClientEditCustomerComponent implements OnInit {

  successmsg: string;

  customerName1;
  customerId1;
  email1;
  postalCode1;
  streetAddress11;
  streetAddress21;
  telephoneNo1;
  town1;



constructor(private activatedroute: ActivatedRoute,private log:LoginserviceService,private route: Router) { 
  activatedroute.params.subscribe(data => {
    this.customerId1 = data.customerId;
  });
  activatedroute.queryParams.subscribe(data => {
    this.customerName1 = data.customerName;
  });
  activatedroute.queryParams.subscribe(data => {
    this.email1=data.email;
  });
  activatedroute.queryParams.subscribe(data => {
    this.postalCode1=data.postalCode;
  });
  activatedroute.queryParams.subscribe(data => {
    this.streetAddress11=data.streetAddress1;
  });
  activatedroute.queryParams.subscribe(data => {
    this.streetAddress21=data.streetAddress2;
  });
  activatedroute.queryParams.subscribe(data => {
    this.telephoneNo1=data.telephoneNo;
  });
  activatedroute.queryParams.subscribe(data => {
    this.town1=data.town;
  });
}

ngOnInit() {
}

updateCustomer(editCustomerForm){
  this.log.updateCustomer(editCustomerForm.value).subscribe(data=>{
        if(data.statuscode === 200){
            console.log(data);
           this.successmsg='Customer details Updated successfully !!';
           setTimeout(()=>{
               this.successmsg=null;
           },4000);
           this.route.navigateByUrl('/client-other-customer-operation');
        }
  });
}







}
