import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

adminMsg;
  
  constructor() { }

  ngOnInit() {
    
  }

displayAdminMsg(){
    this.adminMsg='true';
     setTimeout(()=>{
        this.adminMsg=null;
     },1200)
}

}
