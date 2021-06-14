import { Product } from './../model/product';
import { Category } from './../model/category';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-productlist',
  templateUrl: './productlist.component.html',
  styleUrls: ['./productlist.component.css']
})
export class ProductlistComponent implements OnInit {

  categories: Array<Category> = [];
  products: Array<Product> = [];
  namePage: String = 'product/';

  constructor(private userService: UserService, private router : Router) { }

  ngOnInit(): void {
    this.getCategory();
    this.getProduct("LAPTOP");
  }

  getCategory(){
    this.userService.getCategory()
          .subscribe(
            (data: Category[]) => {
              this.categories = data; 
            },
            error => {
              console.log(error);
            });
  }

  getProduct(name: String){
      this.userService.getProductByCategory(name)
        .subscribe(
          (data: Category) => {
            this.products = data.products;
          },
          error => {
            console.log(error);
          });
  }

  promotion(price: number){
    if(price > 0)
    {
      return true;
    }else
    {
      return false;
    }
  }

  ridrect(name: String)
  {
    this.router.navigate([`${this.namePage}${name}`]);
  }
}
