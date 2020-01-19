import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { LoginserviceService } from '../loginservice.service';

@Component({
  selector: 'app-edit-account',
  templateUrl: './edit-account.component.html',
  styleUrls: ['./edit-account.component.css']
})
export class EditAccountComponent implements OnInit {

   userName1;
   password1;
   accountType1;
   successmsg: string;

  constructor(private activatedroute: ActivatedRoute,private log:LoginserviceService,private route: Router) { 
    activatedroute.params.subscribe(data => {
      this.userName1 = data.userName;
    });
    activatedroute.queryParams.subscribe(data => {
      this.password1 = data.password;
    });
    activatedroute.queryParams.subscribe(data => {
      this.accountType1 = data.accountType;
    });

  }

  ngOnInit() {
  }
 
  updateUser(account){
    this.log.updateAccount(account.value).subscribe(data=>{
          if(data.statuscode === 200){
              console.log(data);
             this.successmsg='Account Updated successfully !!';
             setTimeout(()=>{
                 this.successmsg=null;
             },4000);
             this.route.navigateByUrl('/accounts-operation');
          }
    });
  }



}
