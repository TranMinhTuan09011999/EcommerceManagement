import { Category } from './../../../model/category';
import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-list-categories',
  templateUrl: './list-categories.component.html',
  styleUrls: ['./list-categories.component.css']
})
export class ListCategoriesComponent implements OnInit {
  categories: Category[] = [];
  thisCategory!: Category;
  pageNumber: number = 1;
  filter: any;

  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.getCategory();
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
            },
            error => {
              console.log(error);
            });
  }

  deleteCategory(id: number) {
    this.userService.deleteCategory(id)
          .subscribe(
            (data) => {
              window.location.reload();
            },
            error => {
              console.log(error);
            });
  }

}
