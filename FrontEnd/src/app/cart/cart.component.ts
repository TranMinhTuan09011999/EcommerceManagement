import { Component, OnInit } from '@angular/core';
import { Cart } from '../cart';
import { CartService } from '../service/cart.service';
import { TokenStorageService } from '../service/token-storage.service';
import { UserService } from '../service/user.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  carts: Array<Cart> = [];
  token: any;
  indexStr!: String;

  constructor(private cartService: CartService, private tokenStorageService: TokenStorageService) { }

  ngOnInit(): void {
    const user = this.tokenStorageService.getUser();
    console.log(user.id);
    this.getCartDetailByUser(user.id);
  }

  getCartDetailByUser(userId: number){
    this.token = this.tokenStorageService.getToken();
    console.log(this.token);
    this.cartService.getCartDetailByUser(this.token,userId)
          .subscribe(
            (data: Cart[]) => {
              console.log(data);
              this.carts = data; 
            },
            error => {
              console.log(error);
            });
  }

  deleteCartById(id: number){
    this.token = this.tokenStorageService.getToken();
    this.cartService.deleteCartById(this.token, id)
          .subscribe(
            (data) => {
              console.log(data); 
              this.reloadPage();
            },
            error => {
              console.log(error);
            }
          );
  }

  increase(id: number, index: number){
    this.token = this.tokenStorageService.getToken();
    index++;
    this.cartService.updateCartById(this.token, id, index)
          .subscribe(
            (data) => {
              this.reloadPage();
            },
            error => {
              console.log(error);
            }
          );
  }

  decrease(id: number, index: number){
    this.token = this.tokenStorageService.getToken();
    index--;
    this.cartService.updateCartById(this.token, id, index)
          .subscribe(
            (data) => {
              this.reloadPage();
            },
            error => {
              console.log(error);
            }
          );
  }

  reloadPage(): void {
    window.location.reload();
  }
}
