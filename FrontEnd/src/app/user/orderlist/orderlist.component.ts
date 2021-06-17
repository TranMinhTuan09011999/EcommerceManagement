import { Component, OnInit } from '@angular/core';
import { Checkout } from 'src/app/checkout';
import { CartService } from 'src/app/service/cart.service';
import { TokenStorageService } from 'src/app/service/token-storage.service';

@Component({
  selector: 'app-orderlist',
  templateUrl: './orderlist.component.html',
  styleUrls: ['./orderlist.component.css']
})
export class OrderlistComponent implements OnInit {

  products: Array<Checkout> = [];
  token: any;
  status!: String;

  constructor(private cartService: CartService, private tokenStorageService: TokenStorageService) { }

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
}
