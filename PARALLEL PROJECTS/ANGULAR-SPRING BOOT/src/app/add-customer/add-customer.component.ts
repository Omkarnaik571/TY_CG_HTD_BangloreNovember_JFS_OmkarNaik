import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginserviceService } from '../loginservice.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-add-customer',
  templateUrl: './add-customer.component.html',
  styleUrls: ['./add-customer.component.css']
})
export class AddCustomerComponent implements OnInit {
  msg: string;
  successmsg: string;

  constructor(private route: Router, public log: LoginserviceService) { }

  ngOnInit() {
  }

  onEdit() {
    window.scrollTo(0, 0);
  }


  addCustomer(addCustomerForm: NgForm) {
    this.log.addCustomerDetails(addCustomerForm.value).subscribe(
      data => {
        console.log(data);
        if (data.statuscode === 200) {
          this.successmsg = data.message;
          this.onEdit();
          setTimeout(() => {
            this.successmsg = null;
          }, 4000);
          addCustomerForm.reset();
          // this.route.navigateByUrl('/other-customer-operation');
        }
        //end of if
        else {
          this.msg = data.message;
          this.onEdit();
          setTimeout(() => {
            this.msg = null;
          }, 4000);
        }
      },
      err => {
        console.log(err);
      })
  }//end of method




}
