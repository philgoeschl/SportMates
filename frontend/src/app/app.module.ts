import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {JwtModule} from "@auth0/angular-jwt";
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { UserListComponent } from './user-list/user-list.component';
import { UserFormComponent } from './user-form/user-form.component';
import {BsDatepickerModule} from "ngx-bootstrap";
import { RegisterComponent } from './register/register.component';
import { EventListComponent } from './event-list/event-list.component';
import { EventFormComponent } from './event-form/event-form.component';
import {FileUploadModule} from 'ng2-file-upload';
import {SafePipe} from './safe.pipe';
export function tokenGetter(){
  return localStorage.getItem('access_token');
}
@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    LogoutComponent,
    UserListComponent,
    UserFormComponent,
    RegisterComponent,
    EventListComponent,
    EventFormComponent,
    SafePipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    FileUploadModule,
    ReactiveFormsModule,
    BsDatepickerModule.forRoot(),
    JwtModule.forRoot({
      config:{
        tokenGetter: tokenGetter,
        whitelistedDomains: ['localhost:4200']
      }
    })
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
