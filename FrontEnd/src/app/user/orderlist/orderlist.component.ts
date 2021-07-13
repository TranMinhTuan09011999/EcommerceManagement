import { Component, OnInit } from '@angular/core';
import { Checkout } from 'src/app/checkout';
import { CartService } from 'src/app/service/cart.service';
import { TokenStorageService } from 'src/app/service/token-storage.service';
import { Router } from '@angular/router';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-orderlist',
  templateUrl: './orderlist.component.html',
  styleUrls: ['./orderlist.component.css']
})

//TODO: Update all status of order in user
export class OrderlistComponent implements OnInit {
  [x: string]: any;

  products: Array<Checkout> = [];
  token: any;
  order: any;
  status!: String;
  namePage: String = 'orderDetail/';

  constructor(private cartService: CartService, private tokenStorageService: TokenStorageService,  private router : Router, private userService: UserService) { }

  ngOnInit(): void {
    const user = this.tokenStorageService.getUser();
    this.getOrderListByUserId(user.id);
  }

  getOrderListByUserId(userId: number){
    this.token = this.tokenStorageService.getToken();
    this.cartService.getOrderList(this.token, userId)
          .subscribe(
            (data: Checkout[]) => {
              this.products = data;
              console.log(this.products);
            },
            error => {
              console.log(error);
            });
    }

  ridrect(id: number)
  {
    this.router.navigate([`${this.namePage}${id}`]);
  }

  cancel(id: number)
  {
    this.token = this.tokenStorageService.getToken();
    this.userService.cancel(this.token,id,3)
    .subscribe(
      (data: Checkout) => {
        this.order = data;
        this.getOrderListByUserId(this.order.user_id);
      },
      error => {
        console.log(error);
      });
    }

    reloadPage(): void {
      window.location.reload();
    }
  }
  
