import {Component, OnInit} from '@angular/core';
import {SportService} from '../services/sport.service';
import {Sport} from '../api/sport';
import {Router} from '@angular/router';
import {Event} from '../api/event';
import {UserService} from "../services/user.service";
import {User} from "../api/user";


@Component({
  selector: 'app-sport-list',
  templateUrl: './sport-list.component.html',
  styleUrls: ['./sport-list.component.scss']
})
export class SportListComponent implements OnInit {

  sports: Array<Sport>;
  sportsID: Array<Number>;
  users: Array<User>;

  constructor(private sportService: SportService, private router: Router, private userService: UserService) {
  }

  ngOnInit() {

    this.sportService.getAll()
      .subscribe((response: any) => {
        this.sports = response._embedded.sports;
        console.log(this.sports)

        for (let entry of this.sports){
        this.userService.getAll()
          .subscribe((users: any) => {
            this.users = users;

            console.log(this.sports)
            //this.sportsID = this.users.find(x=>x.id == this.id).sports



              })
}
      });
  }



  createSport() {
    this.router.navigate(['/sport-form']);
  }

  deleteSport(sport: Sport) {

    this.sportService.delete(sport)
      .subscribe(() => {
        this.ngOnInit();
      });

  }

}
