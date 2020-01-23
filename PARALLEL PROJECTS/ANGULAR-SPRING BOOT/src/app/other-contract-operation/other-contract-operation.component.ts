import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { LoginserviceService } from '../loginservice.service';

@Component({
  selector: 'app-other-contract-operation',
  templateUrl: './other-contract-operation.component.html',
  styleUrls: ['./other-contract-operation.component.css']
})
export class OtherContractOperationComponent implements OnInit {

  contracts: contract[];
  msg: string;
  successmsg: string;
  message : string;




  constructor(private route: Router, private log: LoginserviceService,private activatedroute: ActivatedRoute) {
    this.viewAllContract();
  }

  ngOnInit() {
  }

  viewAllContract() {
    this.log.displayContract().subscribe(data => {
      console.log(data);
      this.contracts = data.bean;
    });
  }

  deleteContract(contract) {
    this.log.deleteContract(contract).subscribe(data => {
      if (data.statuscode === 200) {
        this.contracts.splice(this.contracts.indexOf(contract),1);
        this.message='Contract deleted successfully !!';
        setTimeout(()=>{
            this.message=null;
        },5000)
      } 
    },err=>{
      console.log(err);   
    }
    );
  }
deleteMessage(){
  this.message=null;
}

updateContract(contract){
 this.route.navigate(
   [`editContract/${contract.contractNo}`],
   {queryParams:{quantity: contract.quantity,customerId: contract.customerId,productId: contract.productId,
    deliveryDate: contract.deliveryDate,contractStatus: contract.contractStatus} ,
   });

}

}
