import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {UserService} from '../services/user.service';
import {User} from '../api/user';



@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.scss']
})
export class UserListComponent implements OnInit {

  users: Array<User>;
  isAdmin: boolean;

  constructor(private userService: UserService) {
  }

  ngOnInit() {

    this.userService.getAll()
      .subscribe((response: any) => {
        this.users = response._embedded.users;
      });
    this.isAdmin = this.userService.getRole();
    //  console.log(this.isAdmin);
  }

  editUser(user: User) {

    this.userService.update(user)
      .subscribe(() => {
        alert('edited successfully');
        this.ngOnInit();
      });

  }
}
