import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/model/user';
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

  constructor(private userService: UserService) { }

  ngOnInit(): void {
    this.getAllUsers();
  }

  getAllUsers(){

    this.userService.getAllUsers()
          .subscribe(
            (data: User[]) => {
              this.users = data; 
              this.users.forEach(user => {
                // user.roles.name = 
              })
              console.log(this.users);
            },
            error => {
              console.log(error);
            });
  }

}