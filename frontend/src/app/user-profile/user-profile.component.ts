import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {UserService} from "../services/user.service";
import {User} from "../api/user";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Sport} from "../api/sport";
import {SportService} from "../services/sport.service";
import {compareNumbers} from "@angular/compiler-cli/src/diagnostics/typescript_version";

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
  sports: Array<Sport>
  sportOptions;
  id: number;
  sportsID: Array<Number>;
  users: Array<User>;
  user
  shouldNavigateToList: boolean;
  data
  sportNames: Array<string>
  sportName
  constructor(private route: ActivatedRoute, private router: Router, private userService: UserService,private sportService: SportService) { }

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
        this.usernameShow = this.currentUser;
        this.id = this.users.find(x=>x.username == this.currentUser).id
        this.firstName = this.users.find(x=>x.username == this.currentUser).firstName
        this.lastName = this.users.find(x=>x.username == this.currentUser).lastName
        this.sportsID = this.users.find(x=>x.id == this.id).sports



        this.userService.getById(this.id)
          .subscribe((response) => {
            this.userForm.patchValue(response);
            this.sportsID = response.sports;





        this.sportService.getforUser()
          .subscribe((sports: any) => {
            this.sports = sports;
            this.sportNames =[];
            console.log(this.sportsID)
            for (let entry of this.sportsID) {
              this.sportName = this.sports.find(x=>x.id == entry).sportName
              this.sportNames.push(this.sportName)
              console.log(this.sportNames)
            }
            console.log(this.sportNames)
          });
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
