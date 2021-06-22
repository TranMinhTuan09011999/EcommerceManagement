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
  
  id!: number;
  clickedDelete = false;

  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.getCategory();
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
              
            },
            error => {
              console.log(error);
            });
    window.location.reload();
  }

  cancelBtnClick() {
    this.clickedDelete = false;
  }

  clickedDeleteBtn(id: number) {
    this.clickedDelete = true;
    this.id = id;
  }

}
