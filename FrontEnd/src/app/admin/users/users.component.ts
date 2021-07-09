import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/model/user';
import { TokenStorageService } from 'src/app/service/token-storage.service';
import { UserService } from 'src/app/service/user.service';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {
  users: User[] = [];
  filter: any;
  pageNumber: number = 1;
  clickedDelete = false;

  constructor(private userService: UserService,
              private tokenStorageService: TokenStorageService) { }

  ngOnInit(): void {
    this.getAllUsers();
  }

  getAllUsers(){

    this.userService.getAllUsers()
          .subscribe(
            (data: User[]) => {
              this.users = data; 
              this.users.forEach((user, index) => {
                let temp = this.tokenStorageService.getUser();
                if (user.id === temp.id) {
                  this.users.splice(index, 1);
                  console.log("11111111111 " + temp.id);
                  console.log(this.users);
                }
              })
              console.log(this.users);
            },
            error => {
              console.log(error);
            });
  }
}