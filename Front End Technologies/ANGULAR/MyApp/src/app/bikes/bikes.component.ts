import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-bikes',
  templateUrl: './bikes.component.html',
  styleUrls: ['./bikes.component.css']
})
export class BikesComponent implements OnInit {


  selectedBike;

  bikes = [
    {
      name: 'BmW',
      imgUrl: 'https://cdn.pixabay.com/photo/2016/04/07/06/53/bmw-1313343__340.jpg'
    },
    {
      name: 'Ducati',
      imgUrl: 'https://cdn.pixabay.com/photo/2014/07/31/23/05/ducati-407111__340.jpg'
    },
    {
      name: 'Harley DavidSon',
      imgUrl: 'https://cdn.pixabay.com/photo/2018/10/29/19/14/motorcycle-3781800__340.jpg'
    }


  ];



  constructor() {
  }

  selectBike(bike) {
    this.selectedBike = bike;
  }

  ngOnInit() {
  }

}
