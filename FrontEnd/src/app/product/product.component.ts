import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Cart } from '../cart';
import { CartService } from '../service/cart.service';
import { TokenStorageService } from '../service/token-storage.service';
import { ImageDetail } from '../model/image-detail';
import { UserService } from '../service/user.service';
import { Product } from '../model/product';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

  productName: String = '';
  product!: Product;
  IsPromotion = false;
  imageDetails: Array<ImageDetail> = [];
  imageId!: number;
  token: any;

  constructor(private router : Router, private route: ActivatedRoute, private userService: UserService, private tokenStorageService: TokenStorageService, private cartService: CartService) { }

  ngOnInit(): void {
    this.productName = this.route.snapshot.params['name'];
    this.getProductDetail(this.productName);
  }

  getProductDetail(name: String){
    this.userService.getProductDetail(name)
          .subscribe(
            (data: Product) => {
              this.product = data; 
              if(this.product.price > 0)
              {
                this.IsPromotion = true;
              }
              this.imageId = this.product.id;
              this.userService.getImageDetail(this.imageId)
                .subscribe(
                  (data: ImageDetail[]) => {
                    this.imageDetails = data; 
                  },
                  error => {
                    console.log(error);
                  }
                );
            },
            error => {
              console.log(error);
            });
  }

  addToCart(){
    this.token = this.tokenStorageService.getToken();
    const user = this.tokenStorageService.getUser();

    this.cartService.addToCart(this.token, this.product.id, user.id, 1, this.product.price)
          .subscribe(
            (data: Cart[]) => {
              console.log(data);
              this.router.navigate(['/cart']).then(() => {this.reloadPage()});
            },
            error => {
              console.log(error);
            });
  }
  reloadPage(): void {
    window.location.reload();
  }
}
