import {Event} from "../api/event";
import {HttpClient} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {map} from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class EventService {

  constructor(private http: HttpClient) {
  }

  getAll() {
    return this.http.get('/api/events').pipe(
      map((response: any) => {
        return response._embedded.events;
      })
    );
  }

  getById(id: string) {
    return this.http.get('/api/dto/events/' + id).pipe(map((res: any) => {
      res.eventDateTime = new Date(res.eventDateTime);
      return res;
    }));
  }

  getByIdZ(id: number) {
    return this.http.get('/api/dto/events/' + id).pipe(map((res: any) => {
      if (res.dayOfBirth) {
        res.dayOfBirth = new Date(res.dayOfBirth);
      }
      return res;
    }));
  }


  update(event: Event) {
    return this.http.put('/api/dto/events/' + event.id, event);
  }

  delete(event) {
    return this.http.delete('/api/events/' + event.id);
  }

  create(event: Event) {
    return this.http.post('/api/dto/events', event);
  }
}
