import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { LoginserviceService } from '../loginservice.service';

@Component({
  selector: 'app-edit-land',
  templateUrl: './edit-land.component.html',
  styleUrls: ['./edit-land.component.css']
})
export class EditLandComponent implements OnInit {


  successmsg: string;
  msg: string;

  plotNumber1;
  acquiredDate1;
  landValue1;
  location1;
  
  constructor(private activatedroute: ActivatedRoute,private log:LoginserviceService,private route: Router) { 
    activatedroute.params.subscribe(data => {
      this.plotNumber1 = data.plotNumber;
    });
    activatedroute.queryParams.subscribe(data => {
      this.acquiredDate1 = data.acquiredDate;
    });
    activatedroute.queryParams.subscribe(data => {
      this.landValue1 = data.landValue;
    });
    activatedroute.queryParams.subscribe(data => {
      this.location1 = data.location;
    });

  }

  ngOnInit() {
  }

  updateLand(editLandForm){
    this.log.updateLand(editLandForm.value).subscribe(data=>{
          if(data.statuscode === 200){
              console.log(data);
             this.successmsg='Land Updated successfully !!';
             setTimeout(()=>{
                 this.successmsg=null;
             },4000);
             this.route.navigateByUrl('/other-land-operation');
          }
    });
  }





}
