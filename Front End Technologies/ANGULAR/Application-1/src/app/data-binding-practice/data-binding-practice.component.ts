import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-data-binding-practice',
  templateUrl: './data-binding-practice.component.html',
  styleUrls: ['./data-binding-practice.component.css']
})
export class DataBindingPracticeComponent implements OnInit {

  flag=true;
  biDirectional;
  constructor() { 

  }

   dataEntered(){
       console.log(this.biDirectional);
       this.flag=!this.flag;
      }

  ngOnInit() {
  }

}
