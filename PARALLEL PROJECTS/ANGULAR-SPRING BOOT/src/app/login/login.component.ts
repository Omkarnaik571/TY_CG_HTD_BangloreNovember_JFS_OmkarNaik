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
       localStorage.setItem('account',JSON.stringify(data.bean['0']));
       if(data.bean['0'].accountType === 'admin'){
         this.route.navigateByUrl('admin');
       }
       else if(data.bean['0'].accountType === 'client'){
        this.route.navigateByUrl('client');
      }
      else{
        this.route.navigateByUrl('scheduler');
      }
      console.log(data.bean['0'].accountType);
      console.log('end of if');
      } 
      
      else {
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
