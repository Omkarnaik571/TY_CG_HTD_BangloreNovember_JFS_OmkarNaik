import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { LoginserviceService } from '../loginservice.service';

@Component({
  selector: 'app-edit-product',
  templateUrl: './edit-product.component.html',
  styleUrls: ['./edit-product.component.css']
})
export class EditProductComponent implements OnInit {

  successmsg: string;
  msg: string;
  productId1;
  productName1;
  

  constructor(private activatedroute: ActivatedRoute, private log: LoginserviceService, private route: Router) {
    activatedroute.params.subscribe(data => {
      this.productId1 = data.productId;
    });
    activatedroute.queryParams.subscribe(data => {
      this.productName1 = data.productName;
    });
  }

  ngOnInit() {
  }

  updateTheProduct(editProductForm) {
    this.log.updateProduct(editProductForm.value).subscribe(data => {
      if (data.statuscode === 200) {
        console.log(data);
        this.successmsg = 'Product Updated successfully !!';
        setTimeout(() => {
          this.successmsg = null;
        }, 4000);
        this.route.navigateByUrl('/other-product-operation');
      }
    });
  }

}
