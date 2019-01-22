import { Component, OnInit } from '@angular/core';
import {UserService} from "../services/user.service";

@Component({
  selector: 'app-navigation-bar',
  templateUrl: './navigation-bar.component.html',
  styleUrls: ['./navigation-bar.component.scss']
})
export class NavigationBarComponent implements OnInit {

  loggedIn: boolean;
  userRole: string;
  isAdmin: boolean;


  constructor(private userService: UserService) {
    this.userRole = this.userService.userRole


    this.loggedIn = this.userService.isLoggedIn;
    this.isAdmin = this.loggedIn && this.userService.userRole.includes('ROLE_ADMIN');
    //console.log(this.isAdmin)
  }

  ngOnInit() {
    this.userService.loggedInChange.subscribe((isLoggedIn) => {
      this.loggedIn = isLoggedIn;
      this.isAdmin = this.loggedIn && this.userService.userRole.includes('ROLE_ADMIN');
      console.log(this.isAdmin)
    });
  }

  logout() {
    this.userService.logout();
  }

}
