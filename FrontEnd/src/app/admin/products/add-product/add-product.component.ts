import { UserService } from 'src/app/service/user.service';
import { AuthService } from './../../../service/auth.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Product } from './../../../model/product';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { Category } from 'src/app/model/category';

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
  categories: Category[] = [];
  categoryName: string = 'Choose a Category';
  category!: Category;

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

    this.getCategory();
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

  getCategory(){
    this.userService.getCategory()
          .subscribe(
            (data: Category[]) => {
              data.forEach(s => {
                if (s.deletestatus !== 1) {
                  this.categories.push(s);
                }
              });
            },
            error => {
              console.log(error);
            });
  }

  getCategoryByName(name: string) {
    this.userService.getCategoryByName(name)
          .subscribe(
            (data: Category) => {
              this.category = data; 
              console.log(data);
              console.log(this.categoryName);
            },
            error => {
              console.log(error);
            });
  }

  addProduct(categoryName: string) {
    let product = new Product();
    product.name = this.f.name.value;
    product.price = this.f.price.value;
    product.promotion = this.f.promotion.value;
    product.description = this.f.description.value;
    product.image = this.f.image.value;
    product.deletestatus = 0;
    product.categoryId = this.category.id;
    console.log(product);
    this.userService.createProduct(product)
        .subscribe((data: string) => {
          console.log("thêm thành công sẩn phẩm");
        }, err => {
          console.log(err);
        })
  }

  onSubmit() {
    this.submitted = true;
    if (this.f.invalid) {
      return;
    } 
    this.addProduct(this.categoryName);
    console.log('123');
  }

}
