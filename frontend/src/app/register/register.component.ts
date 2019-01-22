import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {AbstractControl, FormBuilder, FormControl, FormGroup, ValidatorFn, Validators} from '@angular/forms';
import { first } from 'rxjs/operators';

import {UserService} from "../services/user.service";
import {Sport} from "../api/sport";
import {User} from "../api/user";



@Component({
  selector: 'app-register',
  templateUrl: 'register.component.html',
  styleUrls: ['./register.component.scss']
  })



export class RegisterComponent implements OnInit {
  registerForm: FormGroup;
  loading = false;
  submitted = false;
  users: Array<User>;
  usernames;
  alreadyExists: boolean;
  show = false;


  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private userService: UserService) { }

  ngOnInit() {



    this.registerForm = new FormGroup({
      'encodeNumber': new FormControl(1),
      'firstName': new FormControl('', [Validators.required, Validators.minLength(2)]),
      'lastName': new FormControl('', [Validators.required, Validators.minLength(2)]),
      'username': new FormControl('', [Validators.required,Validators.minLength(4)]),
      'password' : new FormControl('', {
      validators: [Validators.required, Validators.minLength(5)], updateOn: 'blur'}),
      'isAdmin': new FormControl(),
      'eMail': new FormControl('', [Validators.required, Validators.minLength(3), Validators.pattern("^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$")]),
      'dayOfBirth': new FormControl(),
      'homeTown': new FormControl('', [Validators.required, Validators.minLength(3)]),
      'userLocation': new FormControl(),

    });

  }


  // convenience getter for easy access to form fields
  get f() { return this.registerForm.controls; }

  onSubmit() {
    this.submitted = true;

    // stop here if form is invalid
    if (this.registerForm.invalid) {
      return;

    }

    this.loading = true;
    this.userService.create(this.registerForm.value)
      .pipe(first())
      .subscribe(
        data => {
          alert('Registration successful');
          this.router.navigate(['']);
        },
        error => {
          alert('Failed');
          this.loading = false;
        });
  }


}
