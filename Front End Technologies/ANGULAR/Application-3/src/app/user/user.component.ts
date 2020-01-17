import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  id;
  userDetails;
  constructor(private activatedRouter: ActivatedRoute) {
    activatedRouter.params.subscribe(data => {
      console.log(data);
      this.id = data.id;
    });
    this.activatedRouter.queryParams.subscribe(resp => {
      console.log(resp);
      this.userDetails = resp;
    });

  }

  ngOnInit() {
  }

}
