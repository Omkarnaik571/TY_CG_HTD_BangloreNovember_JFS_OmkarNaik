import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
  import { from } from 'rxjs';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  product: ProductDetails[];

  constructor(private http: HttpClient) {
      this.dataForProducts();
   }

  ngOnInit() {
  }

  dataForProducts(){
    this.http.get<ProductDetails[]>('../../assets/products.json').subscribe(
       data=>{
         console.log(data);
         this.product=data;
       }
    );
  }

}

interface ProductDetails{
   name: string;
   image: string;
   price:number;

}