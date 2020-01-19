import { Component, OnInit } from '@angular/core';
import { LoginserviceService } from '../loginservice.service';
import { log } from 'util';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-accounts-operation',
  templateUrl: './accounts-operation.component.html',
  styleUrls: ['./accounts-operation.component.css']
})
export class AccountsOperationComponent implements OnInit {

msg : string;
allAccounts:accounts[];

  constructor(private log:LoginserviceService, private route: Router) { 
    this.displayAccounts();
  }

  ngOnInit() {
  }

  displayAccounts(){
    this.log.displayAccounts().subscribe(data=>{
         this.allAccounts=data;

    });
  }
    deleteUser(account){
      this.log.deleteAccount(account).subscribe(data=>{
        this.allAccounts.splice(this.allAccounts.indexOf(account),1);
        if(data.statuscode === 200){
           console.log(data);
           this.msg='Account deleted successfully !!';
        }
           setTimeout(()=>{
                 this.msg=null;
           },4000)

      });
    }
    

    updateUser(user){
      console.log('update user hitted first');
      this.route.navigate(
        [`editAccount/${user.userName}`],
        {queryParams:{password: user.password, accountType: user.accountType}, 
        });
     console.log('udtae user finished navigating ..');
     }
  
  


}
