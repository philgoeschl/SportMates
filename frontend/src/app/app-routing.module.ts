import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {LoginComponent} from "./login/login.component";
import {AuthGuard} from "./auth.guard";
import {UserListComponent} from "./user-list/user-list.component";
import {UserFormComponent} from "./user-form/user-form.component";
import {RegisterComponent} from "./register/register.component";
import {UserListResolver} from "./resolver/userList.resolver";


const routes: Routes = [
  {path: '', redirectTo: '/login', pathMatch: 'full'},
  {path: 'register', component: RegisterComponent},
  {path: 'user-list', component: UserListComponent, canActivate:[AuthGuard]},
  {path: 'user-form', component: UserFormComponent, canActivate:[AuthGuard]},
  {path: 'login', component: LoginComponent},
  {path: 'user-form/:id', component: UserFormComponent, canActivate: [AuthGuard]}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
