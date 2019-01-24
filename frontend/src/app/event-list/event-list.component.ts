import {Component, OnInit} from '@angular/core';
import {Event} from '../api/event';
import {EventService} from '../services/event.service';
import {Router} from '@angular/router';
import {UserService} from '../services/user.service';

@Component({
  selector: 'app-event-list',
  templateUrl: './event-list.component.html',
  styleUrls: ['./event-list.component.scss']
})
export class EventListComponent implements OnInit {

  events: Array<Event>;
  eventArray;
  currentLoggedInUser: string;
  event;
idEvent
  constructor(private eventService: EventService, private router: Router, private userService: UserService) {
  }

  ngOnInit() {

    this.updateCurrentLoggedInUser();

    console.log(this.currentLoggedInUser)
    this.event=[]
    this.eventService.getAll()
      .subscribe((events: any) => {
        this.events = events;
        this.eventArray = events;
      });

  }

  deleteEvent(event: Event) {

    this.eventService.delete(event)
      .subscribe(() => {
        this.ngOnInit();
      });

  }

  updateCurrentLoggedInUser(){
    this.currentLoggedInUser = this.userService.currLoggedInUserName;
  }

  createEvent() {
    this.router.navigate(['/event-form']);
  }

  filterEvents(filterValue){
    if(filterValue){
      this.eventArray = this.events.filter((event) => {
        return event.eventTitle.toLowerCase().indexOf(filterValue.toLowerCase()) !== -1 ||
          event.eventTown.toLowerCase().indexOf(filterValue.toLowerCase()) !== -1;
      });
    } else {
      this.eventArray = this.events;
    }

  }





}
