import { Component, OnInit } from '@angular/core';
import { OperationsService } from '../operations.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-add-posts',
  templateUrl: './add-posts.component.html',
  styleUrls: ['./add-posts.component.css']
})
export class AddPostsComponent implements OnInit {

  detail: details[];
msg: string;
  constructor(private opt: OperationsService) { 
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

  addDetails(singleDetail: details){
    this.detail.push(singleDetail);
    this.msg='Data added successfully !!';
    setTimeout(()=>{
       this.msg=null;
    },4000)
  }




}
