import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {UserService} from "../services/user.service";
import {User} from "../api/user";
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.scss']
})
export class UserProfileComponent implements OnInit {
  userForm;
  currentUser: string;
  firstName: string;
  id: number;
  users: Array<User>;
  userArray
  shouldNavigateToList: boolean;
  mapUsers: Map<string, User>;
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
    });
    this.userService.getAll()
      .subscribe((users: any) => {
        this.users = users;
        /*this.currentUser = this.userService.currLoggedInUserName;

        console.log(this.currentUser)
        this.firstName = this.users.find(x=>x.username == this.currentUser).firstName;
        console.log(this.firstName)
        //this.loadData()*/
        this.loadData()
        this.id = this.users.find(x=>x.username == this.currentUser).id;

        this.userService.getById(this.id)
          .subscribe((response) => {
            this.userForm.patchValue(response);
          });
      });


  }

  loadData() {
    this.currentUser = this.userService.currLoggedInUserName;
    console.log(this.currentUser)
    console.log(this.userArray)
    this.userArray = this.users.find(x=>x.username == this.currentUser);
    this.firstName = this.users.find(x=>x.username == this.currentUser).firstName;
    this.id = this.users.find(x=>x.username == this.currentUser).id;
    console.log(this.userArray)
    const data = this.route.snapshot.data;

  }

  saveUser() {

    const user = this.userForm.value;
    if (user.id) {
      this.userService.update(user)
        .subscribe((response) => {
          alert('updated successfully');
          this.userForm.patchValue(response);
          if (this.shouldNavigateToList) {
            this.navigateToList();
          }
        });
    } else {
      this.userService.create(user)
        .subscribe((response: any) => {
          alert('created successfully');
          if (this.shouldNavigateToList) {
            this.navigateToList();
          } else {
            this.router.navigate(['/user-form', response.id]);
          }
        });
    }
  }
  navigateToList() {
    this.router.navigate(['/user-list']);
  }

  setShouldNavigateToList() {
    this.shouldNavigateToList = true;
  }

}
