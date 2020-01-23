import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthGuardService implements CanActivate{

  canActivate(route : ActivatedRouteSnapshot): boolean{
   const account=JSON.parse(localStorage.getItem('account'));
   const type=route.data.type;
   if(account.accountType === type){
        return true;
   }
    return false;
  }


  constructor() { }


}
