import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthGuardService implements CanActivate {

  canActivate(route: ActivatedRouteSnapshot): boolean {
    let expectedReolesArray = route.data.expectedRoles;
    let userDetails = JSON.parse(localStorage.getItem('userDetails'));
    let expectedRole: string;
    for (let index in expectedReolesArray) {
      if (userDetails && userDetails.userBean['0'].role === expectedReolesArray[index]) {
        expectedRole = expectedReolesArray[index];
      }

    }
    if (userDetails && userDetails.userBean['0'].role === expectedRole) {
      return true;
    }
    else {
      return false;
    }
  }


  constructor() { }
}
