import { Component, OnInit } from '@angular/core';
import { ProductService } from '../product.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-get-products',
  templateUrl: './get-products.component.html',
  styleUrls: ['./get-products.component.css']
})
export class GetProductsComponent implements OnInit {

  products: product[];
  message: string;
  search : string;

  constructor(private productservice: ProductService, private router: Router) {
    this.getProducts();
  }

  ngOnInit() {
  }


  getProducts() {
    this.productservice.getData().subscribe(data => {
      console.log(data);
      this.products = data;
    }, err => {
      console.log(err);
    }
    )
  }


  deleteProduct(product: product) {
    this.productservice.deleteData(product).subscribe(data => {
      console.log(data);
      if (data.message === 'Success !!') {
        this.products.splice(this.products.indexOf(product), 1);
        this.message = data.message;
      }
    }, err => {
      console.log(err);
    });

  }

  selectProduct(product) {
    this.productservice.selectedProductToUpdate = product;
    this.router.navigateByUrl('/edit-product');
  }


  deleteMessage() {
    this.message = null;
  }

}
