import {Component, OnInit} from '@angular/core';
import {Event} from '../api/event';
import {EventService} from '../services/event.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-event-list',
  templateUrl: './event-list.component.html',
  styleUrls: ['./event-list.component.scss']
})
export class EventListComponent implements OnInit {

  events: Array<Event>;

  constructor(private eventService: EventService, private router: Router) {
  }

  ngOnInit() {

    this.eventService.getAll()
      .subscribe((events: any) => {
        this.events = events;
      });

  }

  deleteEvent(event: Event) {

    this.eventService.delete(event)
      .subscribe(() => {
        this.ngOnInit();
      });

  }

  createEvent() {
    this.router.navigate(['/event-form']);
  }
}
