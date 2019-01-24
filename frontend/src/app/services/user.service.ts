import {Injectable} from '@angular/core';
import {HttpClient, HttpErrorResponse, HttpHeaders} from '@angular/common/http';
import {catchError, delay, map} from 'rxjs/operators';
import {Router} from '@angular/router';
import {config, Observable, of, Subject} from 'rxjs';
import {JwtHelperService} from '@auth0/angular-jwt';
import {User} from "../api/user";
import {Sport} from "../api/sport";
import { Http } from '@angular/http';



@Injectable({
  providedIn: 'root'
})
export class UserService {
  currLoggedInUserName: string;
  isLoggedIn = false;
  loggedInChange: Subject<boolean> = new Subject<boolean>();
  jwtHelperService: JwtHelperService;
  userRole: string;
  accessTokenLocalStorageKey = 'access_token';
  users;

  constructor(private http: HttpClient, private router: Router) {
    this.jwtHelperService = new JwtHelperService();
    const token = localStorage.getItem(this.accessTokenLocalStorageKey);
    if (token) {
      console.log('Token expiration date: '
        + this.jwtHelperService.getTokenExpirationDate(token));
      this.isLoggedIn = !this.jwtHelperService.isTokenExpired(token);
      const decodedToken = this.jwtHelperService.decodeToken(token);
      this.userRole = decodedToken.authorities;
      this.currLoggedInUserName = decodedToken.sub;
    }
    this.loggedInChange.subscribe((value) => {
      this.isLoggedIn = value;

      if (this.isLoggedIn === false) {
        this.currLoggedInUserName = '';
        this.userRole = '';
      }

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
      console.log(this.jwtHelperService.decodeToken(token));
      const decodedToken = this.jwtHelperService.decodeToken(token);
      this.currLoggedInUserName = decodedToken.sub;
      this.userRole = decodedToken.authorities;
      this.loggedInChange.next(true);
      this.router.navigate(['/user-profile'])

      return res;
    }));
  }


  logout() {
    localStorage.removeItem(this.accessTokenLocalStorageKey);
    this.loggedInChange.next(false);
    this.router.navigate(['']);
  }


  getById(id: number) {
    return this.http.get('/api/dto/users/' + id).pipe(map((res: any) => {
      if (res.dayOfBirth) {
        res.dayOfBirth = new Date(res.dayOfBirth);
      }
      return res;
    }));
  }

  getByIdString(id: string) {
    return this.http.get('/api/dto/users/' + id).pipe(map((res: any) => {
      if (res.dayOfBirth) {
        res.dayOfBirth = new Date(res.dayOfBirth);
      }
      return res;
    }));
  }

  getAll() {
    return this.http.get('/api/users').pipe(
      map((response: any) => {
        return response._embedded.users;
      })
    );
  }



  getAllRegister() {
    return this.http.get('/api/users');
  }

  delete(user) {
    return this.http.delete('/api/users/' + user.id);
  }

  update(user: User) {
    return this.http.put('/api/dto/users/' + user.id, user);
  }

  create(user: User) {
    return this.http.post('/api/dto/users', user);
  }




}
