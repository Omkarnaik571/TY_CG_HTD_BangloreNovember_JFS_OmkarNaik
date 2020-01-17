import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  mySubscription: Subscription;

  constructor(private router: Router) {

  }

  goToId(id, name, imgurl) {
    // this.router.navigateByUrl(`/user-component/${id}`);
    this.router.navigate([`/user-component/${id}`], {
      queryParams: { name: name, imgurl: imgurl }
    });
  }

  ngOnInit() {
  }




}
