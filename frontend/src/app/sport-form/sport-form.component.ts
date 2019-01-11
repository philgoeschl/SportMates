import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {SportService} from '../services/sport.service';

@Component({
  selector: 'app-sport-form',
  templateUrl: './sport-form.component.html',
  styleUrls: ['./sport-form.component.scss']
})
export class SportFormComponent implements OnInit {

  sportForm;
  shouldNavigateToList: boolean;

  constructor(private route: ActivatedRoute, private router: Router, private sportService: SportService) {
  }

  ngOnInit() {
    this.sportForm = new FormGroup({
      'id': new FormControl(),
      'sportName': new FormControl(),
      'sportDescription': new FormControl(),
      'team': new FormControl(),
      'teamSize': new FormControl()
    });
  }

  saveSport() {

    const sport = this.sportForm.value;
    if (sport.id) {
      this.sportService.update(sport)
        .subscribe((response) => {
          alert('updated successfully');
          this.sportForm.setValue(response);
          if (this.shouldNavigateToList) {
            this.navigateToList();
          }
        });
    } else {
      this.sportService.create(sport)
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
    this.router.navigate(['/login']);
  }

  setShouldNavigateToList() {
    this.shouldNavigateToList = true;
  }

}
