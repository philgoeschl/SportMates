import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {LoginComponent} from "./login/login.component";
import {AuthGuard} from "./auth.guard";
import {UserListComponent} from "./user-list/user-list.component";
import {UserFormComponent} from "./user-form/user-form.component";


const routes: Routes = [
  {path: '', redirectTo: '/user-list', pathMatch: 'full'},
  {path: 'user-list', component: UserListComponent, canActivate:[AuthGuard]},
  {path: 'login', component: LoginComponent},
  {path: 'user-form', component: UserFormComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
