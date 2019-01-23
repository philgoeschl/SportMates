import { Component, OnInit } from '@angular/core';
import {SportService} from "../services/sport.service";
import {Sport} from "../api/sport";
import {ActivatedRoute, Router} from "@angular/router";
import {UserService} from "../services/user.service";
import {User} from "../api/user";

@Component({
  selector: 'app-sport-info',
  templateUrl: './sport-info.component.html',
  styleUrls: ['./sport-info.component.scss']
})
export class SportInfoComponent implements OnInit {

  sport
  sportID
  users: Array<User>
  participatingUsers
  usernames: Array<string>
  id
  data
  constructor(private sportService:SportService,private router: Router,private route: ActivatedRoute,private userService: UserService) { }

  ngOnInit() {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.sportService.getById(id)
        .subscribe((response) => {
          this.sport = <Sport>response;
          this.sportID = this.sport.id
          console.log(this.sportID)


          this.userService.getAll()
            .subscribe((users: any) => {
              this.users = users;
              console.log(this.users)
              this.data = users.map(x => x.id);
              console.log(this.data)

              for (let entry of this.data) {
                this.userService.getById(1)
                  .subscribe((response) => {
                    this.sportID = response.sports;
                    console.log(this.sportID)

              }
                  )}


            })
        });
    }



  }




}
