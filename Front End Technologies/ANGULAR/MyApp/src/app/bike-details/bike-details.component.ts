import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-bike-details',
  templateUrl: './bike-details.component.html',
  styleUrls: ['./bike-details.component.css']
})
export class BikeDetailsComponent implements OnInit {

@Input()
bikeDetails;

  constructor() { }

  ngOnInit() {
  }

}
