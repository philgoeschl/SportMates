import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {LoginComponent} from './login/login.component';
import {AuthGuard} from './auth.guard';
import {UserListComponent} from './user-list/user-list.component';
import {UserFormComponent} from './user-form/user-form.component';
import {RegisterComponent} from './register/register.component';
import {EventListComponent} from './event-list/event-list.component';
import {EventFormComponent} from './event-form/event-form.component';
import {EventResolver} from './resolver/events.resolver';
import {SportFormComponent} from './sport-form/sport-form.component';
import {SportListComponent} from './sport-list/sport-list.component';
import {Sport} from './api/sport';
import {UserProfileComponent} from "./user-profile/user-profile.component";
import {EventInfoComponent} from './event-info/event-info.component';


const routes: Routes = [
  {path: '', redirectTo: '/login', pathMatch: 'full'},
  {path: 'register', component: RegisterComponent},
  {path: 'user-list', component: UserListComponent, canActivate: [AuthGuard]},
  {path: 'user-form', component: UserFormComponent, canActivate: [AuthGuard]},
  {path: 'login', component: LoginComponent},
  {path: 'user-form', component: UserFormComponent},
  {path: 'event-list', component: EventListComponent, canActivate: [AuthGuard]},
  {path: 'event-form', component: EventFormComponent, canActivate: [AuthGuard]},
  {path: 'event-form/:id', component: EventFormComponent, canActivate: [AuthGuard]},
  {path: 'user-form/:id', component: UserFormComponent, canActivate: [AuthGuard]},
  {path: 'sport-form', component: SportFormComponent},
  {path: 'sport-list', component: SportListComponent},
  {path: 'sport-form/:id', component: SportFormComponent},
  {path: 'user-profile', component: UserProfileComponent},
  {path: 'event-info/:id', component: EventInfoComponent, canActivate:[AuthGuard]},


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
