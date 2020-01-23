import { Component, OnInit } from '@angular/core';
import { isNullOrUndefined } from 'util';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private route: Router) { }

  ngOnInit() {
  }


  isAdmin(){
   if(!isNullOrUndefined(localStorage.getItem('account'))){
       const account=JSON.parse(localStorage.getItem('account'));
       if(account.accountType === 'admin'){
            return true;
       }else{
         return false;
       }
   }else{
     return false;
   }
  }
//end of is admin

isClient(){
  if(!isNullOrUndefined(localStorage.getItem('account'))){
      const account=JSON.parse(localStorage.getItem('account'));
      if(account.accountType === 'client'){
           return true;
      }else{
        return false;
      }
  }else{
    return false;
  }
 }
//end of is client


isScheduler(){
  if(!isNullOrUndefined(localStorage.getItem('account'))){
      const account=JSON.parse(localStorage.getItem('account'));
      if(account.accountType === 'scheduler'){
           return true;
      }else{
        return false;
      }
  }else{
    return false;
  }
 }
//end of is scheduler

logout(){
  localStorage.removeItem('account');
  this.route.navigateByUrl('login');
}

login(){
  if(isNullOrUndefined(localStorage.getItem('account'))){
    return false;
  }
  else{
    return true;
  }
}




}
