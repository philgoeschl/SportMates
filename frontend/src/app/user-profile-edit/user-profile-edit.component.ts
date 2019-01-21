import { Component, OnInit } from '@angular/core';
import {User} from "../api/user";
import {ActivatedRoute, Router} from "@angular/router";
import {UserService} from "../services/user.service";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {SportService} from "../services/sport.service";

@Component({
  selector: 'app-user-profile-edit',
  templateUrl: './user-profile-edit.component.html',
  styleUrls: ['./user-profile-edit.component.scss']
})
export class UserProfileEditComponent implements OnInit {

  userForm;
  currentUser: string;
  firstName: string;
  id: number;
  users: Array<User>;
  userArray
  shouldNavigateToList: boolean;
  sportOptions;
  mapUsers: Map<string, User>;
  constructor(private route: ActivatedRoute, private router: Router, private userService: UserService, private sportService: SportService) { }

  ngOnInit() {
    this.userForm = new FormGroup({
      'id': new FormControl(),
      'firstName': new FormControl('', [Validators.required, Validators.minLength(3)]),
      'lastName': new FormControl('', [Validators.required, Validators.minLength(3)]),
      'username': new FormControl('', [Validators.required, Validators.minLength(3)]),
      'password': new FormControl('', [Validators.minLength(3)]),
      'admin': new FormControl(),
      'eMail': new FormControl('', [Validators.minLength(3),Validators.pattern("^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$")]),
      'dayOfBirth': new FormControl(),
      'homeTown': new FormControl('', [Validators.required, Validators.minLength(3)]),
      'userLocation': new FormControl(),
      'sport': new FormControl(),
    });
    this.userService.getAll()
      .subscribe((users: any) => {
        this.users = users;
        this.currentUser = this.userService.currLoggedInUserName;


        this.id = this.users.find(x=>x.username == this.currentUser).id;

        this.userService.getById(this.id)
          .subscribe((response) => {
            this.userForm.patchValue(response);
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
