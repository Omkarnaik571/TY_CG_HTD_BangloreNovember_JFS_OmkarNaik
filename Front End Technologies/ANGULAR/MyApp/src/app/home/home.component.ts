import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(data: DataService) {
    console.log(data.x);
    data.allProducts.forEach((value, index, array) => {
      console.log(value, index);
    });

  }

  ngOnInit() {
  }

}
