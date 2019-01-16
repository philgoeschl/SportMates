import {Component, OnInit} from '@angular/core';
import {SportService} from '../services/sport.service';
import {Sport} from '../api/sport';
import {Router} from '@angular/router';
import {Event} from '../api/event';


@Component({
  selector: 'app-sport-list',
  templateUrl: './sport-list.component.html',
  styleUrls: ['./sport-list.component.scss']
})
export class SportListComponent implements OnInit {

  sports: Array<Sport>;

  constructor(private sportService: SportService, private router: Router) {
  }

  ngOnInit() {

    this.sportService.getAll()
      .subscribe((response: any) => {
        this.sports = response._embedded.sports;
      });

  }

 /* editSport(sport: Sport) {

    this.sportService.update(sport)
      .subscribe(() => {
        alert('edited successfully');
        this.ngOnInit();
      });

  }*/

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
