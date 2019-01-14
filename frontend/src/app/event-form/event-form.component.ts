import { Component, OnInit } from '@angular/core';
import {EventService} from '../services/event.service';
import {ActivatedRoute, Router} from '@angular/router';
import {FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-event-form',
  templateUrl: './event-form.component.html',
  styleUrls: ['./event-form.component.scss']
})
export class EventFormComponent implements OnInit {

  eventForm;
  shouldNavigateToList: boolean;
  event: any;


  constructor(private eventService: EventService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {

    this.eventForm = new FormGroup({
      'id': new FormControl(),
      'eventTitle': new FormControl('', [Validators.required, Validators.minLength(3)]),
      'eventType': new FormControl('', [Validators.required, Validators.required]),
      'eventDescription': new FormControl(),
      'eventTown': new FormControl('', [Validators.required, Validators.minLength(3)]),
      'eventZIP': new FormControl(),
      'eventStreet': new FormControl(),
      'eventDateTime': new FormControl(),
      'eventOrganizer': new FormControl(),
      'eventImage': new FormControl([]),



    });

    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.eventService.getById(id)
        .subscribe((response) => {
          this.eventForm.patchValue(response);
        });
    }

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
