import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { LoginserviceService } from '../loginservice.service';

@Component({
  selector: 'app-other-land-operation',
  templateUrl: './other-land-operation.component.html',
  styleUrls: ['./other-land-operation.component.css']
})
export class OtherLandOperationComponent implements OnInit {

  lands: LandDetails[];
  msg: string;
  successmsg: string;
  message : string;


  constructor(private route: Router, private log: LoginserviceService,private activatedroute: ActivatedRoute) {
    this.viewAllLand();
   }

  ngOnInit() {
  }


  viewAllLand() {
    this.log.displayLand().subscribe(data => {
      console.log(data);
      this.lands = data.bean;
    });
  }



  deleteLand(land) {
    this.log.deleteLand(land).subscribe(data => {
      if (data.statuscode === 200) {
        this.lands.splice(this.lands.indexOf(land),1);
        this.message='Land deleted successfully !!';
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


updateLand(land){
  this.route.navigate(
    [`editLand/${land.plotNumber}`],
    {queryParams:{acquiredDate: land.acquiredDate,location: land.location,landValue: land.landValue} ,
    });
 
 }






}
