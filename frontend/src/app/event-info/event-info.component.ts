import {Component, OnInit} from '@angular/core';
import {EventService} from '../services/event.service';
import {ActivatedRoute, Router} from '@angular/router';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {SportService} from '../services/sport.service';
import {UserService} from "../services/user.service";

@Component({
  selector: 'app-event-info',
  templateUrl: './event-info.component.html',
  styleUrls: ['./event-info.component.scss']
})
export class EventInfoComponent implements OnInit {

  eventInfo;
  event;
  sportOptions;
  currentLoggedInUser: string;
  userNames: Array<string>


  constructor(private eventService: EventService, private route: ActivatedRoute,
              private router: Router, private sportService: SportService,private userService:UserService) { }

  ngOnInit() {


    this.eventInfo = new FormGroup({
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
      'sport': new FormControl(),
      'users': new FormControl(),
    });

    //this.eventInfo.controls.eventOrganizer.disable();


    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.eventService.getById(id)
        .subscribe((response) => {
          this.event = <Event>response;
          console.log(this.event)
          console.log(this.event.users)
        });
    }
    if(this.event) {
      this.eventInfo.setValue(this.event);
    }





    /*
    RESOLVER related code
    const event = data.event;
    if(event){
      this.eventForm.patchValue(event);
    }*/


    /* Get sports for eventSport */
    this.sportService.getAll()
      .subscribe((sports: any) => {
        this.sportOptions = sports._embedded.sports;
      });


  }



  navigateToList() {
    this.router.navigate(['/event-list']);
  }

  participateEvent() {
    this.currentLoggedInUser = this.userService.currLoggedInUserName.toString();

    this.event.users.push(this.currentLoggedInUser);
    this.userNames = this.event.users

    console.log(this.userNames)
    this.event = this.event;
    this.eventService.update(this.event)
      .subscribe((response) => {
        alert('updated successfully');
        this.router.navigate(['/event-list']);
      });


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

}
