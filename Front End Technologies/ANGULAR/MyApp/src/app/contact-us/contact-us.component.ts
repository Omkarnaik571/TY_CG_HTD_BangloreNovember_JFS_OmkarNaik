import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-contact-us',
  templateUrl: './contact-us.component.html',
  styleUrls: ['./contact-us.component.css']
})
export class ContactUsComponent implements OnInit {

  name:number;

  constructor() { }

  ngOnInit() {
    console.log("Contact us init started..");
  }

  ngDoCheck(){
    console.log("Contact us check started..");
  }

  ngAfterContentInit(){
    console.log("Contact us after content init started..");
  }

  ngOnDestroy(){
    console.log("Contact us Destroy started..");
  }

}
