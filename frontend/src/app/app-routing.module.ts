import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {LoginComponent} from "./login/login.component";
import {AuthGuard} from "./auth.guard";
import {UserListComponent} from "./user-list/user-list.component";
import {UserFormComponent} from "./user-form/user-form.component";
import {RegisterComponent} from "./register/register.component";
import {SportFormComponent} from './sport-form/sport-form.component';
import {SportListComponent} from './sport-list/sport-list.component';


const routes: Routes = [
  {path: '', redirectTo: '/login', pathMatch: 'full'},
  {path: 'register', component: RegisterComponent},
  {path: 'user-list', component: UserListComponent, canActivate:[AuthGuard]},
  {path: 'login', component: LoginComponent},
  {path: 'user-form', component: UserFormComponent},
  {path: 'sport-form', component: SportFormComponent},
  {path: 'sport-list', component: SportListComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
