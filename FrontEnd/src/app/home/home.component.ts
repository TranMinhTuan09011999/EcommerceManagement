import { Product } from './../model/product';
import { Component, OnInit } from '@angular/core';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  products: Array<Product> = [];

  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.getPage();
  }

  getPage(){
    this.userService.getPromotionProduct()
          .subscribe(
            (data: Product[]) => {
              this.products = data; 
            },
            error => {
              console.log(error);
            });
  }

}
