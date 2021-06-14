import { AuthService } from './../service/auth.service';
import { Component, OnInit } from '@angular/core';
import { CartService } from '../service/cart.service';
import { TokenStorageService } from '../service/token-storage.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  username!: string;

  token = '';

  //count!: number;
  count = 0;

  constructor(private tokenStorageService: TokenStorageService, private cartService: CartService) {
    this.token = this.tokenStorageService.getToken();
    const user = this.tokenStorageService.getUser();
    this.cartService.countCartById(this.token, user.id)
          .subscribe(
            (data) => {
              this.count = data;
            },
            error => {
              console.log(error);
            }
          );
   }

  ngOnInit(): void {
    
  }

  countCartById(){
    this.token = this.tokenStorageService.getToken();
    const user = this.tokenStorageService.getUser();
    this.cartService.countCartById(this.token, user.id)
          .subscribe(
            (data) => {
              this.count = data;
            },
            error => {
              console.log(error);
            }
          );
  }

  isLoggedIn():boolean{
    this.token = this.tokenStorageService.getToken();
    if(this.token == '{}')
    {
      return false;
    }else{    
      const user = this.tokenStorageService.getUser();
      this.username = user.username;
      return true;
    }
}

  logout(): void {
    this.tokenStorageService.signOut();
  }
  
}
