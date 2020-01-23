import { Component, OnInit } from '@angular/core';
import { LoginserviceService } from '../loginservice.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-add-land',
  templateUrl: './add-land.component.html',
  styleUrls: ['./add-land.component.css']
})
export class AddLandComponent implements OnInit {

  msg: string;
  successmsg: string;
  constructor(private log: LoginserviceService, private route: Router) { }

  ngOnInit() {
  }

  onEdit() {
    window.scrollTo(0, 0);
  }

  addLand(addLandForm: NgForm) {
    this.log.addLandDetails(addLandForm.value).subscribe(data => {
      console.log(data);
      if (data.statuscode === 200) {
        this.successmsg = 'Land added succesfully !!';
        this.onEdit();
        setTimeout(() => {
          this.successmsg = null;
        }, 5000);
        addLandForm.reset();
      } else {
        this.msg = data.message;
        // addLandForm.reset();
        this.onEdit();
        setTimeout(() => {
          this.msg = null;
        }, 5000);
      }
    }, err => {
      console.log(err);
    });
  }


}
