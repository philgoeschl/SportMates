import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {UserService} from "../services/user.service";
import {User} from "../api/user";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Sport} from "../api/sport";
import {Event} from "../api/event";
import {SportService} from "../services/sport.service";
import {compareNumbers} from "@angular/compiler-cli/src/diagnostics/typescript_version";
import {EventService} from "../services/event.service";



@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.scss']
})
export class UserProfileComponent implements OnInit {
  idparser: number;
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
  events: Array<Event>
  managedEventsToPush
  managedEvents: Array<Event>;
  participatingEvents: Array<Event>;
  id: number;
  sportsID: Array<Number>;
  users: Array<User>;
  user
  shouldNavigateToList: boolean;
  data
  sportNames: Array<string>
  sportName
  eventparse
  constructor(private route: ActivatedRoute, private router: Router, private userService: UserService,private sportService: SportService, private eventService: EventService) { }

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
            console.log(response)




            this.sportService.getforUser()
              .subscribe((sports: any) => {
                this.sports = sports;
                this.sportNames =[];

                for (let entry of this.sportsID) {
                  this.sportName = this.sports.find(x=>x.id == entry).sportName
                  this.sportNames.push(" " + this.sportName)

                }
              });
          });

        this.eventService.getAll()
          .subscribe((events: any) => {
            this.events = events
            this.managedEventsToPush =[];
            this.managedEvents=[]
            //this.managedEventsToPush = this.events.find(x=>x.eventOrganizer == this.currentUser)
            events.forEach(x => {if (x.eventOrganizer.includes(this.currentUser)) this.managedEvents.push(x)});
            this.idparser = 0;
            for (let entry of this.events) {
              this.idparser = this.idparser + 1;
              this.user = []


              this.participatingEvents = [];
              this.eventService.getByIdNumber(this.idparser)
                .subscribe((response) => {
                    this.eventparse = response;


                    if(this.eventparse.users.includes(this.currentUser)){
                      this.participatingEvents.push(this.eventparse)


                    }
                    //this.usersFinalObject.forEach(x => {if (x.sports.includes(this.sportID)) this.participatingUsers.push(x)});


                  }
                )

            }
            console.log(this.participatingEvents)

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
