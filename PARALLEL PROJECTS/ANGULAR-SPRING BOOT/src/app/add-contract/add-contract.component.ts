import { Component, OnInit } from '@angular/core';
import { LoginserviceService } from '../loginservice.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-add-contract',
  templateUrl: './add-contract.component.html',
  styleUrls: ['./add-contract.component.css']
})
export class AddContractComponent implements OnInit {

  msg: string;
  successmsg: string;
  constructor(private log: LoginserviceService, private route: Router) { }

  ngOnInit() {
  }

  onEdit() {
    window.scrollTo(0, 0);
  }

  addContract(adContractForm: NgForm) {
    this.log.addContractDetails(adContractForm.value).subscribe(data => {
      console.log(data);
      if (data.statuscode === 200) {
        this.successmsg = data.message;
        this.onEdit();
        setTimeout(() => {
          this.successmsg = null;
        }, 5000);
        adContractForm.reset();
      } else {
        this.msg = data.message;
        // adContractForm.reset();
        this.onEdit();
        setTimeout(() => {
          this.msg = null;
        }, 5000);
      }
    }, err => {
      console.log(err);
    });
  }



}
