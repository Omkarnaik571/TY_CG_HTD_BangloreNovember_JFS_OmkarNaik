import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../authentication.service';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {


  message: string;
  constructor(private serv: AuthenticationService,private route: Router) { }

  ngOnInit() {
  }

  loginTheUser(form: NgForm) {
    this.serv.loginUser(form.value).subscribe(data => {
      console.log(data);
      if (data.statuscode === 200) {
        this.message = data.message;
        localStorage.setItem('userDetails', JSON.stringify(data));
        console.log('userDetails stored in local storage ');
        this.route.navigateByUrl('/');
        // setTimeout(() => {
        //   this.message = null;
        // }, 5000);
      }
    }, err => {
      console.log(err);
    });


  }



}
