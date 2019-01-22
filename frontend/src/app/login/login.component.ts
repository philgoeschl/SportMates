import {Component, OnInit} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Router} from '@angular/router';
import {UserService} from "../services/user.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  user: any;
  show = false;
  constructor(private userservice: UserService, private router: Router) {
  }

  ngOnInit() {
    this.user = {
      username: '',
      password: ''
    };
  }

  login() {
    this.userservice.login(this.user)
      .subscribe((res: any) => {
      }, (error) => {
        alert('wrong username or password');
      });
  }
}
