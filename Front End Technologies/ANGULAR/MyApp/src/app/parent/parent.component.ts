import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-parent',
  templateUrl: './parent.component.html',
  styleUrls: ['./parent.component.css']
})
export class ParentComponent implements OnInit {

  dataFromChild;

  student = {
    name: 'omkar',
    age: 22
  }

  getChildData(data) {
    this.dataFromChild = data;
  }

  constructor() { }
  ngOnInit() {
  }

}
