import { AuthService } from './../../../service/auth.service';
import { ImageDetail } from './../../../model/image-detail';
import { Product } from './../../../model/product';
import { UserService } from 'src/app/service/user.service';
import { ActivatedRoute, Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { FullProduct } from 'src/app/model/full-product';

@Component({
  selector: 'app-edit-product',
  templateUrl: './edit-product.component.html',
  styleUrls: ['./edit-product.component.css']
})

export class EditProductComponent implements OnInit {
  form!: FormGroup;
  submitted = false;
  productName!: string;
  product!: Product;
  imageDetails: Array<ImageDetail> = [];
  imageId!: number;
  fullProduct!: FullProduct;

  constructor(private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private authService: AuthService,
    private userService: UserService) { }

  ngOnInit(): void {
    this.productName = this.route.snapshot.params['name'];

    this.form = this.formBuilder.group({
      id: [{value: '', disabled: true}],
      name: ['', Validators.required],
      price: ['', [Validators.required]],
      description: ['', Validators.required],
      promotion: ['', [Validators.required, Validators.max(100)]],
      image: ['', [Validators.required]],
      subImage1: ['', [Validators.required]],
      subImage2: ['', [Validators.required]],
      subImage3: ['', [Validators.required]]
    })

    this.userService.getProductDetail(this.productName)
          .subscribe(
            (data: Product) => {
              this.product = data; 
              this.imageId = this.product.id;
              this.userService.getImageDetail(this.imageId)
                .subscribe(
                  (data: ImageDetail[]) => {
                    this.imageDetails = data; 
                    this.form.patchValue(this.product);
                    this.form.patchValue({
                      subImage1: this.imageDetails[0].image,
                      subImage2: this.imageDetails[1].image,
                      subImage3: this.imageDetails[2].image
                    })
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

  get f() {
    return this.form.controls;
  }

  onSubmit() {
    this.submitted = true;
    if (this.f.invalid) {
      return;
    }
  }

}
