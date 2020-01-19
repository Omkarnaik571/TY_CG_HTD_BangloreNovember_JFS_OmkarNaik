import { Component, OnInit } from '@angular/core';
import { LoginserviceService } from '../loginservice.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  msg: string;

  constructor(private log: LoginserviceService, private route: Router) { }

  ngOnInit() {
  }


  loginTheUser(loginForm: NgForm) {
    this.log.login(loginForm.value).subscribe(data => {
      console.log(data);
      if (data.statuscode === 201) {
        this.route.navigateByUrl('/');
      } else {
        this.msg = 'Invalid usernamee and password';
        setTimeout(() => {
          this.msg = null;
        }, 2000);
      }
    }, err => {
      console.log(err);
    });
  }



}
