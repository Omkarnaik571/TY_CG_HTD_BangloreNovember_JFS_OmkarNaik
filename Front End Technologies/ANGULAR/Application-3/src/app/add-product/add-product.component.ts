import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {

  message: string;
  constructor(private http: HttpClient) { }

  ngOnInit() {
  }

  addProduct(form: NgForm) {
    this.http.post<any>(
      'http://localhost:8081/addproduct',form.value).subscribe(data => {
        console.log(data);
        this.message = data.message;
        setTimeout(() => {
          this.message = null;
        }, 2000);
        form.reset();
      }, err => {
        console.log(err);
      })

  }


}

