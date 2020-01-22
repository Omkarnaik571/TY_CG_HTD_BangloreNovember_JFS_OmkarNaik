import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { LoginserviceService } from '../loginservice.service';

@Component({
  selector: 'app-client-edit-contract',
  templateUrl: './client-edit-contract.component.html',
  styleUrls: ['./client-edit-contract.component.css']
})
export class ClientEditContractComponent implements OnInit {

  successmsg : string;
msg : string;

  contractNo1;
  quantity1;
  customerId1;
  productId1;
  contractStatus1;
  deliveryDate1;

  constructor(private activatedroute: ActivatedRoute,private log:LoginserviceService,private route: Router) {
    activatedroute.params.subscribe(data => {
      this.contractNo1 = data.contractNo;
    });
    activatedroute.queryParams.subscribe(data => {
      this.customerId1 = data.customerId;
    });
    activatedroute.queryParams.subscribe(data => {
      this.productId1 = data.productId;
    });
    activatedroute.queryParams.subscribe(data => {
      this.quantity1 = data.quantity;
    });
    activatedroute.queryParams.subscribe(data => {
      this.deliveryDate1 = data.deliveryDate;
    });
    activatedroute.queryParams.subscribe(data => {
      this.contractStatus1 = data.contractStatus;
    });
  }

  ngOnInit() {
  }

  updateContract(editContractForm){
    this.log.updateContract(editContractForm.value).subscribe(data=>{
          if(data.statuscode === 200){
              console.log(data);
             this.successmsg='Contarct Updated successfully !!';
             setTimeout(()=>{
                 this.successmsg=null;
             },4000);
           this.route.navigateByUrl('/client-other-contract-operation');
          }
    });
  }


}