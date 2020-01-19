import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { LoginserviceService } from '../loginservice.service';

@Component({
  selector: 'app-client-other-contract-opeartion',
  templateUrl: './client-other-contract-opeartion.component.html',
  styleUrls: ['./client-other-contract-opeartion.component.css']
})
export class ClientOtherContractOpeartionComponent implements OnInit {

  contracts: contract[];
  msg: string;
  successmsg: string;
  message : string;




  constructor(private route: Router, private log: LoginserviceService,private activatedroute: ActivatedRoute) {
    
  }

  ngOnInit() {
  }

  onEdit() {
    window.scrollTo(0, 0);
  }

  viewAllContract() {
    this.log.displayContract().subscribe(data => {
      console.log(data);
      this.contracts = data.bean;
    });
  }

  viewsingleContract(singleContractForm){
    this.log.displaySingleContract(singleContractForm.value).subscribe(
      data=>{
        console.log(data);
        if(data.statuscode === 201){
          console.log(data);
          this.contracts=data.bean;
          this.successmsg='The Contract found successfully !!';
          setTimeout(()=>{
            this.successmsg=null;
          },3000)
        }
        else{
           this.msg='The Contract id that you have entered does`nt exists !!';
           setTimeout(()=>{
              this.msg=null;
           },3000)
        }
        
      }
    );
 }




  deleteContract(contract) {
    this.log.deleteContract(contract).subscribe(data => {
      if (data.statuscode === 200) {
        this.contracts.splice(this.contracts.indexOf(contract),1);
        this.message='Contract deleted successfully !!';
        this.onEdit();
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
   [`clientEditContract/${contract.contractNo}`],
   {queryParams:{quantity: contract.quantity,ContractId: contract.ContractId,productId: contract.productId,
    deliveryDate: contract.deliveryDate,contractStatus: contract.contractStatus} ,
   });

}

}
