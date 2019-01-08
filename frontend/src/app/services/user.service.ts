import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {map} from 'rxjs/operators';
import {Router} from '@angular/router';
import {Subject} from 'rxjs';
import {JwtHelperService} from '@auth0/angular-jwt';
import {User} from "../api/user";
import {Actor} from "../api/actor";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  isLoggedIn: boolean;
  loggedInChange: Subject<boolean> = new Subject<boolean>();

  accessTokenLocalStorageKey = 'access_token';

  constructor(private http: HttpClient, private router: Router) {
    this.isLoggedIn = !!localStorage.getItem(this.accessTokenLocalStorageKey);
    this.loggedInChange.subscribe((value) => {
      this.isLoggedIn = value;
    });
  }

  login(user) {
    return this.http.post('/api/auth/', user, {
      'headers': new HttpHeaders({'Content-Type': 'application/json'}),
      'responseType': 'text',
      observe: 'response'
    }).pipe(map((res: any) => {
      const token = res.headers.get('Authorization').replace(/^Bearer /, '');
      localStorage.setItem(this.accessTokenLocalStorageKey, token);
      const helper = new JwtHelperService();
      console.log(helper.decodeToken(token));
      this.loggedInChange.next(true);
      this.router.navigate(['/user-list']);
      return res;
    }));
  }

  logout() {
    localStorage.removeItem(this.accessTokenLocalStorageKey);
    this.loggedInChange.next(false);
    this.router.navigate(['/login']);
  }

  getAll() {
    return this.http.get('/api/users');
  }

  getById(id: string) {
    return this.http.get('/api/users/' + id);
  }

  update(user: User) {
    return this.http.put('/api/users/' + user.id, user);
  }

  create(user: User) {
    return this.http.post('/api/users', user);
  }

  getRole() {
    const helper = new JwtHelperService();
    let token = localStorage.getItem(this.accessTokenLocalStorageKey);
    token = helper.decodeToken(token);
    // console.log(token)
    if (token['authorities'].includes('ROLE_ADMIN')) {
      return true;
    }

    return false;
  }

}
