import { UserService } from 'src/app/service/user.service';
import { ActivatedRoute, Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Component, Input, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { Category } from 'src/app/model/category';

@Component({
  selector: 'app-add-category',
  templateUrl: './add-category.component.html',
  styleUrls: ['./add-category.component.css']
})
export class AddCategoryComponent implements OnInit {

  name!: string;
  isAddMode!: boolean;
  form!: FormGroup;
  submitted = false;

  categories: Category[] = [];
  thisCategory!: Category;
  pageNumber: number = 1;
  filter: any;

  constructor(private formBuilder: FormBuilder,
              private route: ActivatedRoute,
              private router: Router,
              private userService: UserService) { }

  ngOnInit(): void {
    this.name = this.route.snapshot.params['name'];
    this.isAddMode = !this.name;
    
    this.getCategory();

    this.form = this.formBuilder.group({
      name: ['', Validators.required]
    })

    if (!this.isAddMode) {
      this.getCategoryByName(this.name);
    }
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

  getCategoryByName(name: string) {
    this.userService.getCategoryByName(name)
          .subscribe(
            (data: Category) => {
              this.thisCategory = data;
              this.form.patchValue({
                name: data.categoryName
              })
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
