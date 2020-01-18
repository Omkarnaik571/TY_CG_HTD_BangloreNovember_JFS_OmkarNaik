import { Component, OnInit } from '@angular/core';
import { OperationsService } from '../operations.service';
import { Router, RouterLink } from '@angular/router';

@Component({
  selector: 'app-posts',
  templateUrl: './posts.component.html',
  styleUrls: ['./posts.component.css']
})
export class PostsComponent implements OnInit {

detail: details[];
msg: string;
userId1;
id1;
title1;
body1;


  constructor(private opt: OperationsService, private route: Router) { 
this.getDetails();
  }

  ngOnInit() {
  }

  getDetails(){
    this.opt.getDetails().subscribe(
      data=>{
        console.log(data);
        this.detail=data;
      }
    );
  }

  deleteDetails(singleDetail){
    this.detail.splice(this.detail.indexOf(singleDetail),1);
     this.msg='Detail deleted successfully !!';
     setTimeout(()=>{
       this.msg=null;
     },4000)
  }

  updateDetails(singleDetail){
    console.log('update executed..');
     
   }




}
