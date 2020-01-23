import { Component, OnInit } from '@angular/core';
import { LoginserviceService } from '../loginservice.service';
import { Router } from '@angular/router';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {


  msg: string;
  successmsg: string;
  constructor(private log: LoginserviceService, private route: Router) { }

  ngOnInit() {
  }

  onEdit() {
    window.scrollTo(0, 0);
  }

  addTheProduct(addProduct: NgForm) {
    this.log.addProductDetails(addProduct.value).subscribe(data => {
      console.log(data);
      if (data.statuscode === 200) {
        this.successmsg = 'Product added successfuly !!';
        this.onEdit();
        setTimeout(() => {
          this.successmsg = null;
        }, 5000);
        addProduct.reset();
      } else {
        this.msg = 'The product id that you have entered, already exists !!';
        this.onEdit();
        setTimeout(() => {
          this.msg = null;
        }, 5000);
      }
    }, err => {
      console.log(err);
    });
  }





}
