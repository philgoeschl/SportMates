import {Component, OnInit} from '@angular/core';
import {EventService} from '../services/event.service';
import {ActivatedRoute, Router} from '@angular/router';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {SportService} from '../services/sport.service';

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



  constructor(private eventService: EventService, private route: ActivatedRoute,
              private router: Router, private sportService: SportService) { }

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
    });

    //this.eventInfo.controls.eventOrganizer.disable();


    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.eventService.getById(id)
        .subscribe((response) => {
          this.event = <Event>response;
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


}
