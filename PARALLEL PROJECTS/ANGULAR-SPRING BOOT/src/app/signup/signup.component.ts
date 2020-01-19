import { Component, OnInit } from '@angular/core';
import { LoginserviceService } from '../loginservice.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  msg: string;
  constructor(private log: LoginserviceService, private route: Router) { }

  ngOnInit() {
  }


  signinTheUser(signinForm: NgForm) {
    this.log.signUp(signinForm.value).subscribe(data => {
      console.log(data);
      if (data.statuscode === 200) {
        this.msg = 'User added successfully !!';
        // this.route.navigateByUrl('/admin');
        setTimeout(() => {
          this.msg=null;
        }, 3000);
        signinForm.reset();
      } else {
        this.msg = data.message;
        setTimeout(() => {
          this.msg = null;
        }, 3000);
      }
    }, err => {
      console.log(err);
    });
  }



}
