import { Component, OnInit } from '@angular/core';
import {User} from "../api/user";
import {ActivatedRoute, Router} from "@angular/router";
import {UserService} from "../services/user.service";
import {FormArray, FormControl, FormGroup, Validators} from "@angular/forms";
import {SportService} from "../services/sport.service";
import {Sport} from "../api/sport";

@Component({
  selector: 'app-user-profile-edit',
  templateUrl: './user-profile-edit.component.html',
  styleUrls: ['./user-profile-edit.component.scss']
})
export class UserProfileEditComponent implements OnInit {

  userForm;
  currentUser: string;

  id: number;
  firstName: string;
  lastName: string;
  username: string;
  eMail: string;
  dayOfBirth: Date;
  homeTown: string;
  userLocation: string;
  password: string;
  admin: boolean;
  users: Array<User>;
  sports: Array<Number>;
  user: Array<User>;
  shouldNavigateToList: boolean;
  sportOptions;
  mapUsers: Map<string, User>;
  constructor(private route: ActivatedRoute, private router: Router, private userService: UserService, private sportService: SportService) { }

  ngOnInit() {
    this.userForm = new FormGroup({
      'id': new FormControl(),
      'encodeNumber': new FormControl(0),
      'firstName': new FormControl('', [Validators.required, Validators.minLength(2)]),
      'lastName': new FormControl('', [Validators.required, Validators.minLength(2)]),
      'username': new FormControl('', [Validators.required,Validators.minLength(4)]),
      'eMail': new FormControl('', [Validators.required, Validators.minLength(3), Validators.pattern("^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$")]),
      'dayOfBirth': new FormControl(),
      'admin': new FormControl(),
      'password': new FormControl(),
      'homeTown': new FormControl('', [Validators.required, Validators.minLength(3)]),
      'userLocation': new FormControl(),
      'sports': new FormControl(),
    });
    this.userService.getAll()
      .subscribe((users: any) => {
        this.users = users;
        this.currentUser = this.userService.currLoggedInUserName;

        this.id = this.users.find(x=>x.username == this.currentUser).id;
        this.sports = this.users.find(x=>x.username == this.currentUser).sports;
        console.log(this.id)

        this.userService.getById(this.id)
          .subscribe((response) => {
            this.userForm.patchValue(response);
            console.log(response)

          });

        this.sportService.getforUser()
          .subscribe((sports: any) => {
            this.sportOptions = sports;
          });

      });


  }



  saveUser() {

    const user = this.userForm.value;
    if (user.id) {
      this.userService.update(user)
        .subscribe((response) => {
          alert('updated successfully');
          this.userForm.patchValue(response);
          this.router.navigate(['/user-profile']);
        });
    } else {
      this.userService.create(user)
        .subscribe((response: any) => {
          alert('created successfully');
          if (this.shouldNavigateToList) {
            this.navigateToList();
          } else {
            this.router.navigate(['/user-profile']);
          }
        });
    }
  }
  navigateToList() {
    this.router.navigate(['/user-profile']);
  }

  setShouldNavigateToList() {
    this.shouldNavigateToList = true;
  }

}
