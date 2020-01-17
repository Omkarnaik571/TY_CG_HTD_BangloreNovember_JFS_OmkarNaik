import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-data-binding',
  templateUrl: './data-binding.component.html',
  styleUrls: ['./data-binding.component.css']
})
export class DataBindingComponent implements OnInit {

  
  twoWaydata;
  flag=true;

   url="https://cdn.pixabay.com/photo/2015/07/28/22/03/fireworks-865104_960_720.jpg";
  constructor() {
    // setInterval(
    //   ()=>{
    //     this.flag=!this.flag;
    //   },3000
    // )

   }
    
    changeDisplay(){
      console.log(this.twoWaydata);
      this.flag=!this.flag;
    }
    

  ngOnInit() {
  }

}
