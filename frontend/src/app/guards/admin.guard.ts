import { Injectable } from '@angular/core';
import {CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router} from '@angular/router';
import { Observable } from 'rxjs';
import {UserService} from "../services/user.service";
import {state} from "@angular/animations";

@Injectable({
  providedIn: 'root'
})
export class AdminGuard implements CanActivate {

  constructor(
    private userService: UserService, private router: Router){

}

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
    if (!this.userService.isLoggedIn){
      this.router.navigate(['']);
      return false;
    }
    if (! (this.userService.userRole === 'ROLE_ADMIN')) {
      this.router.navigate(['/user-profile']);
      return false;
    }

    return true;
  }


}
