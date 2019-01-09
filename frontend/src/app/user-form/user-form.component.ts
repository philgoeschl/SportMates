import { Component, OnInit } from '@angular/core';
import {UserService} from "../services/user.service";
import {ActivatedRoute, Router} from "@angular/router";
import {AbstractControl, FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.scss']
})
export class UserFormComponent implements OnInit {

  public BooleanValue: Boolean;
  userForm;
  shouldNavigateToList: boolean;

  constructor(private userService: UserService, private route: ActivatedRoute, private router: Router) {
  }


    ngOnInit()
    {
      this.userForm = new FormGroup({
        //'id': new FormControl(),
        'firstName': new FormControl('', [Validators.required, Validators.minLength(3)]),
        'lastName': new FormControl('', [Validators.required, Validators.minLength(3)]),
        'username': new FormControl('', [Validators.required, Validators.minLength(3)]),
        'password': new FormControl('', [Validators.required, Validators.minLength(3)]),
        'isAdmin': new FormControl(),
        'eMail': new FormControl('', [Validators.required, Validators.minLength(3)]),
        'dayOfBirth': new FormControl(),
        'homeTown': new FormControl('', [Validators.required, Validators.minLength(3)]),
        'userLocation': new FormControl(),
      });




    }

  saveUser() {

    const user = this.userForm.value;
    if (user.id) {
      this.userService.update(user)
        .subscribe((response) => {
          alert('updated successfully');
          this.userForm.setValue(response);
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
