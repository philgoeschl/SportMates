import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {UserService} from "../services/user.service";
import {User} from "../api/user";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Sport} from "../api/sport";

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.scss']
})
export class UserProfileComponent implements OnInit {
  userForm;
  currentUser: string;
  firstName: string;
  lastName: string;
  usernameShow: string;
  eMail: string;
  dayOfBirthShow: Date;
  homeTown: string;
  userLocation: string;
  sports: Array<Sport>;
  id: number;
  users: Array<User>;
  user: Array<User>;
  shouldNavigateToList: boolean;

  constructor(private route: ActivatedRoute, private router: Router, private userService: UserService) { }

  ngOnInit() {
    this.userForm = new FormGroup({
      'id': new FormControl(),
      'firstName': new FormControl('', [Validators.required, Validators.minLength(3)]),
      'lastName': new FormControl('', [Validators.required, Validators.minLength(3)]),
      'username': new FormControl('', [Validators.required, Validators.minLength(3)]),
      'password': new FormControl('', [Validators.minLength(3)]),
      'admin': new FormControl(),
      'eMail': new FormControl('', [Validators.minLength(3)]),
      'dayOfBirth': new FormControl(),
      'homeTown': new FormControl('', [Validators.required, Validators.minLength(3)]),
      'userLocation': new FormControl(),
      'sports': new FormControl(),
    });
    this.userService.getAll()
      .subscribe((users: any) => {
        this.users = users;
        this.currentUser = this.userService.currLoggedInUserName;


        this.id = this.users.find(x=>x.username == this.currentUser).id;
        this.firstName = this.users.find(x=>x.username == this.currentUser).firstName;
        this.lastName = this.users.find(x=>x.username == this.currentUser).lastName;
        this.usernameShow = this.users.find(x=>x.username == this.currentUser).username;
        this.eMail = this.users.find(x=>x.username == this.currentUser).eMail;
        this.dayOfBirthShow = this.users.find(x=>x.username == this.currentUser).dayOfBirth;
        this.homeTown = this.users.find(x=>x.username == this.currentUser).homeTown;
        this.userLocation = this.users.find(x=>x.username == this.currentUser).userLocation;

     this.userService.getById(this.id)
          .subscribe((response) => {
            this.userForm.patchValue(response);
          });
      });


  }




  navigateToList() {
    this.router.navigate(['/user-list']);
  }

  setShouldNavigateToList() {
    this.shouldNavigateToList = true;
  }

}
