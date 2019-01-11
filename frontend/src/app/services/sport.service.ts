import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';
import {Sport} from '../api/sport';

@Injectable({
  providedIn: 'root'
})
export class SportService {

  constructor(private http: HttpClient, private router: Router) {
  }


  getAll() {
    return this.http.get('/api/sports');
  }

  getById(id: string) {
    return this.http.get('/api/sports/' + id);
  }

  update(sport: Sport) {
    return this.http.put('/api/sports/' + sport.id, sport);
  }

  create(sport: Sport) {
    return this.http.post('/api/sports', sport);
  }

}
