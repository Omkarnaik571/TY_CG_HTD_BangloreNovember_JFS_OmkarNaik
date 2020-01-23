import { Component, OnInit } from '@angular/core';
import { LoginserviceService } from '../loginservice.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-login2',
  templateUrl: './login2.component.html',
  styleUrls: ['./login2.component.css']
})
export class Login2Component implements OnInit {

  msg: string;
  isLoading = false;

  constructor(private log: LoginserviceService, private route: Router) { }

  ngOnInit() {
  }


  loginTheUser(loginForm: NgForm) {
    this.log.login(loginForm.value).subscribe(data => {
      console.log(data);
      if (data.statuscode === 201) {
        this.isLoading = true;
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
        
        this.isLoading = true;
        setTimeout(()=>{
           this.isLoading= false;
           this.msg = 'Invalid User name and password';
           setTimeout(() => {
            this.msg = null;
          }, 3000);
        },3000);
        
      }
    }, err => {
      console.log(err);
    });
  }






}
