import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-cards',
  templateUrl: './cards.component.html',
  styleUrls: ['./cards.component.css']
})
export class CardsComponent implements OnInit {

  msg: string;
  flag = false;
  allProducts = [
    {
      name: "Iphone",
      image: "https://cdn.pixabay.com/photo/2016/11/29/05/08/apple-1867461__340.jpg",
      price: 42999
    }, {
      name: "Macbook",
      image: "https://cdn.pixabay.com/photo/2014/05/02/21/50/home-office-336378__340.jpg",
      price: 59999
    }, {
      name: "Canon DSLR",
      image: "https://cdn.pixabay.com/photo/2017/04/22/10/44/camera-2251051__340.jpg",
      price: 31999
    }, {
      name: "Boat Headset",
      image: "https://cdn.pixabay.com/photo/2015/03/26/09/58/headphones-690685__340.jpg",
      price: 1599
    },
    {
      name: "Virtual Reality Play",
      image: "https://cdn.pixabay.com/photo/2017/02/10/14/10/virtual-2055227__340.png",
      price: 6299
    }
  ];



  constructor() { }

  deleteCard(product) {
    this.allProducts.splice(this.allProducts.indexOf(product), 1);
    this.msg = `${product.name} is deleted`;
    console.log('card deleted..');
  }

  click(){
    this.msg = null;
  }

  ngOnInit() {
  }

}
