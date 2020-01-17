import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms';
import { RouterModule } from '@angular/router';
import {ReactiveFormsModule} from '@angular/forms';

import { AppComponent } from './app.component';
import { LoginTemplateComponent } from './login-template/login-template.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { HomeComponent } from './home/home.component';
import { RegisterComponent } from './register/register.component';
import { RegisterFormbuilderComponent } from './register-formbuilder/register-formbuilder.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginTemplateComponent,
    HeaderComponent,
    FooterComponent,
    HomeComponent,
    RegisterComponent,
    RegisterFormbuilderComponent
  ],
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    FormsModule,
    RouterModule.forRoot([
      { path: '', redirectTo: 'login', pathMatch: 'full' },
      { path: 'login', component: LoginTemplateComponent },
      { path: 'register', component: RegisterComponent },
      { path: 'register-formbuilder', component: RegisterFormbuilderComponent }
    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
