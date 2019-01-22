import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Event} from '../api/event';
import {Sport} from '../api/sport';
import {map} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class SportService {

  constructor(private http: HttpClient) {
  }

  getById(id: string) {
    return this.http.get('/api/dto/sports/' + id).pipe(map((res: any) => {
      return res;
    }));
  }

  getByIdNumber(id: number) {
    return this.http.get('/api/dto/sports/' + id).pipe(map((res: any) => {
      return res;
    }));
  }

  getAll() {
    return this.http.get('/api/sports');
  }

  getforUser() {
    return this.http.get('/api/sports').pipe(map((response: any) => {
      return response._embedded.sports;
    }));
  }

  update(sport: Sport) {
    return this.http.put('/api/dto/sports/' + sport.id, sport);
  }

  create(sport: Sport) {
    return this.http.post('/api/sports', sport);
  }

  delete(sport) {
    return this.http.delete('/api/sports/' + sport.id);
  }
}
