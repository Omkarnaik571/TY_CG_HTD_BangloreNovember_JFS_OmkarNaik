import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-late-commers',
  templateUrl: './late-commers.component.html',
  styleUrls: ['./late-commers.component.css']
})
export class LateCommersComponent implements OnInit {

  latecommers = ['Omkar', 'Suraj', 'Saif', 'sunil'];
  message: string;
  flag = false;

  person = 'suraj';

  constructor() {
  }

  deleteLateCommer(name: string) {
    this.latecommers.splice(this.latecommers.indexOf(name), 1);
    this.message = `${name}  is deleted`;
    setTimeout(() => {
      this.message = null;
    }, 2000);
  }



  ngOnInit() {
  }

}
