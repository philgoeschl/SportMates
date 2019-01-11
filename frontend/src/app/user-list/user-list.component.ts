import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Actor} from '../api/actor';

import {Router} from '@angular/router';
import {User} from "../api/user";
import {UserService} from "../services/user.service";

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.scss']
})
export class UserListComponent implements OnInit {

  users: Array<User>;

  constructor(private userService: UserService, private router: Router) {
  }

  ngOnInit() {

    this.userService.getAll()
      .subscribe((users: any) => {
        this.users = users;
      });

  }

  deleteActor(user: User) {

    this.userService.delete(user)
      .subscribe(() => {
        this.ngOnInit();
      });

  }

  createActor() {
    this.router.navigate(['/user-form']);
  }
}
