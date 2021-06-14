import { UserService } from 'src/app/service/user.service';
import { AuthService } from './../../../service/auth.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Product } from './../../../model/product';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {

  form!: FormGroup;
  submitted = false;
  productName!: string;
  product!: Product;
  products: Array<Product> = [];

  constructor(private formBuilder: FormBuilder,
    private route: ActivatedRoute,
    private router: Router,
    private authService: AuthService,
    private userService: UserService) { }

  ngOnInit(): void {

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

    this.getAllProducts();
    
  }

  get f() {
    return this.form.controls;
  }

  getAllProducts() {
    this.userService.getAllProducts()
      .subscribe((res) => {
        res.forEach((data) => {
          this.products.push(data);
        })
      }, (err) => {
        console.log(err);
      })
  }

  onSubmit() {
    this.submitted = true;
    if (this.f.invalid) {
      return;
    }
  }

}
