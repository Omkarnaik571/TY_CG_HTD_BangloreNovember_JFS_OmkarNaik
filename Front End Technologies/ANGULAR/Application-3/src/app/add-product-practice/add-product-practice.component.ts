import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { NgForm } from '@angular/forms';
import { ProductService } from '../product.service';

@Component({
  selector: 'app-add-product-practice',
  templateUrl: './add-product-practice.component.html',
  styleUrls: ['./add-product-practice.component.css']
})
export class AddProductPracticeComponent implements OnInit {


  message: string;
  constructor(private productservice: ProductService) {


  }

  ngOnInit() {
  }

  addProduct(form: NgForm) {
    this.productservice.postData(form.value).subscribe(data => {
      console.log(data);
      this.message = data.message;
      setTimeout(() => {
        this.message = null;
      }, 2000)

    }, err => {
      console.log(err);
    })

  }

}
