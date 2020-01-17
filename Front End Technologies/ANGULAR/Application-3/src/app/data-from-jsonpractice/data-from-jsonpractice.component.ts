import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-data-from-jsonpractice',
  templateUrl: './data-from-jsonpractice.component.html',
  styleUrls: ['./data-from-jsonpractice.component.css']
})
export class DataFromJSONPracticeComponent implements OnInit {

  products: Product[];



  constructor(private http: HttpClient) {
     this.getDataFromJSON();
  }

  ngOnInit() {
  }

  getDataFromJSON() {
    this.http.get<Product[]>('../../assets/products.json').subscribe(data => {
      console.log(data);
      this.products=data;
    })

  }

}

interface Product {
  name: String,
  image: String,
  price: String
}