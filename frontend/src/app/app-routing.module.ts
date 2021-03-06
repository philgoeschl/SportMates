import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {LoginComponent} from './login/login.component';
import {AuthGuard} from './guards/auth.guard';
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
import {UserProfileEditComponent} from "./user-profile-edit/user-profile-edit.component";
import {AdminGuard} from "./guards/admin.guard";
import {AppComponent} from "./app.component";
import {EventInfoComponent} from './event-info/event-info.component';
import {SportInfoComponent} from "./sport-info/sport-info.component";
import {WelcomeComponent} from "./welcome/welcome.component";


const routes: Routes = [
  {path: '', redirectTo: 'welcome', pathMatch: 'full'},
  {path: 'register', component: RegisterComponent},
  {path: 'user-list', component: UserListComponent, canActivate: [AuthGuard]},
  {path: 'user-form', component: UserFormComponent, canActivate: [AdminGuard]},
  {path: 'login', component: LoginComponent},
  {path: 'user-form', component: UserFormComponent, canActivate: [AuthGuard]},
  {path: 'event-list', component: EventListComponent},
  {path: 'event-form', component: EventFormComponent, canActivate: [AuthGuard]},
  {path: 'event-form/:id', component: EventFormComponent, canActivate: [AuthGuard]},
  {path: 'event-info/:id', component: EventInfoComponent, canActivate: [AuthGuard]},
  {path: 'user-form/:id', component: UserFormComponent, canActivate: [AdminGuard]},
  {path: 'sport-form', component: SportFormComponent, canActivate: [AuthGuard]},
  {path: 'sport-list', component: SportListComponent, canActivate: [AuthGuard]},
  {path: 'sport-form/:id', component: SportFormComponent, canActivate: [AuthGuard]},
  {path: 'sport-info/:id', component: SportInfoComponent, canActivate: [AuthGuard]},
  {path: 'user-profile', component: UserProfileComponent, canActivate: [AuthGuard]},
  {path: 'user-profile-edit', component: UserProfileEditComponent, canActivate: [AuthGuard]},
  {path: 'welcome', component: WelcomeComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
