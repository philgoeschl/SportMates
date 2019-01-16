import {Component, OnInit} from '@angular/core';
import {EventService} from '../services/event.service';
import {ActivatedRoute, Router} from '@angular/router';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {SportService} from '../services/sport.service';

@Component({
  selector: 'app-event-form',
  templateUrl: './event-form.component.html',
  styleUrls: ['./event-form.component.scss']
})
export class EventFormComponent implements OnInit {

  eventForm;
  shouldNavigateToList: boolean;
  event: any;
  sportOptions;


  constructor(private eventService: EventService, private route: ActivatedRoute,
              private router: Router, private sportService: SportService) {
  } //

  ngOnInit() {

    /*
    Resolver related code
    const data = this.route.snapshot.data;
     */

    this.eventForm = new FormGroup({
      'id': new FormControl(),
      'eventTitle': new FormControl(),
      'eventType': new FormControl(),
      'eventDescription': new FormControl(),
      'eventTown': new FormControl(),
      'eventZIP': new FormControl(),
      'eventStreet': new FormControl(),
      'eventDateTime': new FormControl(),
      'eventOrganizer': new FormControl(),
      'image': new FormControl([]),
      'eventSport': new FormControl(),


    });


    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.eventService.getById(id)
        .subscribe((response) => {
          this.eventForm.patchValue(response);
        });
    }

    /*
    RESOLVER related code
    const event = data.event;
    if(event){
      this.eventForm.patchValue(event);
    }*/


    /* Get sports for eventSport
        this.sportService.getAll()
        .subscribe((sports: any) => {
        this.sportOptions = sports._embedded.sports;
        });
    */

  }

  saveEvent() {

    const event = this.eventForm.value;
    if (event.id) {
      this.eventService.update(event)
        .subscribe((response) => {
          alert('updated successfully');
          this.eventForm.patchValue(response);
          if (this.shouldNavigateToList) {
            this.navigateToList();
          }
        });
    } else {
      this.eventService.create(event)
        .subscribe((response: any) => {
          alert('created successfully');
          if (this.shouldNavigateToList) {
            this.navigateToList();
          } else {
            this.router.navigate(['/event-form', response.id]);
          }
        });
    }

  }

  navigateToList() {
    this.router.navigate(['/event-list']);
  }

  setShouldNavigateToList() {
    this.shouldNavigateToList = true;
  }

}
