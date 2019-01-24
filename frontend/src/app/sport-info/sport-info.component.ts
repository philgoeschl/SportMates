import {Component, OnDestroy, OnInit} from '@angular/core';
import {SportService} from "../services/sport.service";
import {Sport} from "../api/sport";
import {ActivatedRoute, Router} from "@angular/router";
import {UserService} from "../services/user.service";
import {User} from "../api/user";
import {map} from "rxjs/operators";

@Component({
  selector: 'app-sport-info',
  templateUrl: './sport-info.component.html',
  styleUrls: ['./sport-info.component.scss']
})
export class SportInfoComponent implements OnInit {

  userSportID
  sports
  username
  sport
  user
  usersFinalObject: Array<User>
  sportID
  users: Array<User>
  participatingUsers
  usernames
  sportsCount:number
  sportIDs
  id
  idparser
  data

  constructor(private sportService: SportService, private router: Router, private route: ActivatedRoute, private userService: UserService) {
  }

  ngOnInit() {

    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.sportService.getById(id)
        .subscribe((response) => {
          this.sport = <Sport>response;
          this.sportID = this.sport.id


          this.userService.getAll()
            .subscribe((users: any) => {
              this.users = users;
              this.idparser = 0;
              this.sportsCount=0
              for (let entry of this.users) {
                this.idparser = this.idparser + 1;
                this.sportIDs = [];
                this.user = []
                this.userSportID =[]
                this.usersFinalObject = [];

                this.participatingUsers = [];
                this.userService.getById(this.idparser)
                  .subscribe((response) => {
                      this.userSportID =[]
                      this.user = response;
                      this.userSportID =this.user.sports
                      this.usersFinalObject.push(this.user)

                    if(this.userSportID.includes(this.sportID)){
                      this.participatingUsers.push(this.user)
                      this.sportsCount = this.sportsCount+1

                    }
                    //this.usersFinalObject.forEach(x => {if (x.sports.includes(this.sportID)) this.participatingUsers.push(x)});


                    }
                  )

              }

              //this.participatingUsers  = Array.from(this.participatingUsers.reduce((m, t) => m.set(t.id, t), new Map()).values());
              //this.sportsCount = (this.participatingUsers.count)
              //this.sportsCount = this.sportsCount + 1
              console.log(this.sportsCount)

            })
        });
    }


  }

  removeDuplicates(originalArray, prop) {
    var newArray = [];
    var lookupObject  = {};

    for(var i in originalArray) {
      lookupObject[originalArray[i][prop]] = originalArray[i];
    }

    for(i in lookupObject) {
      newArray.push(lookupObject[i]);
    }
    return newArray;
  }

  navigateToList() {
    this.router.navigate(['/sport-list']);
  }



}
