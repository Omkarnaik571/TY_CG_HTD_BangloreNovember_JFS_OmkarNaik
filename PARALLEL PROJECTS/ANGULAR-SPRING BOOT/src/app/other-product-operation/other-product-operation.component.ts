import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { LoginserviceService } from '../loginservice.service';

@Component({
  selector: 'app-other-product-operation',
  templateUrl: './other-product-operation.component.html',
  styleUrls: ['./other-product-operation.component.css']
})
export class OtherProductOperationComponent implements OnInit {

  products: ProductDetails[];
  msg: string;
  successmsg: string;
  message : string;

  constructor(private route: Router, private log: LoginserviceService,private activatedroute: ActivatedRoute) {
        this.viewAllProduct();
   }

  ngOnInit() {
  }


  viewAllProduct() {
    this.log.displayProduct().subscribe(
     data=>{
       console.log(data);
       this.products=data.bean;
     }

    );
  }


  deleteProduct(product) {
    this.log.deleteProduct(product).subscribe(data => {
      if (data.statuscode === 200) {
        this.products.splice(this.products.indexOf(product),1);
        this.message='product deleted successfully !!';
        setTimeout(()=>{
            this.message=null;
        },4000)
      } 
    },err=>{
      console.log(err);   
    }
    );
  }
deleteMessage(){
  this.message=null;
}

  
updateProduct(product){
  this.route.navigate(
    [`editProduct/${product.productId}`],
    {queryParams:{productName: product.productName} ,
    }); 
 }




}
