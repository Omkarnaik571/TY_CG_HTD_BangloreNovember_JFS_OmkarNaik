import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';


import { AppComponent } from './app.component';
import { headerComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { SectionComponent } from './section/section.component';
import { HomeComponent } from './home/home.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { LoginComponent } from './login/login.component';
import { AboutComponent } from './about/about.component';
import { RegisterComponent } from './register/register.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { SurajComponent } from './suraj/suraj.component';
import { SaifComponent } from './saif/saif.component';
import { OmkarComponent } from './omkar/omkar.component';
import { LateCommersComponent } from './late-commers/late-commers.component';
import { ProductsComponent } from './products/products.component';
import { CardsComponent } from './cards/cards.component';
import { ColorDirectiveDirective } from './color-directive.directive';
import { ParentComponent } from './parent/parent.component';
import { ChildComponent } from './child/child.component';
import { BikesComponent } from './bikes/bikes.component';
import { BikeDetailsComponent } from './bike-details/bike-details.component';
import { CarsComponent } from './cars/cars.component';
import { CarDetailsComponent } from './car-details/car-details.component';

@NgModule({
  declarations: [
    AppComponent,
    headerComponent,
    FooterComponent,
    SectionComponent,
    HomeComponent,
    ContactUsComponent,
    LoginComponent,
    AboutComponent,
    RegisterComponent,
    PageNotFoundComponent,
    SurajComponent,
    SaifComponent,
    OmkarComponent,
    LateCommersComponent,
    ProductsComponent,
    CardsComponent,
    ColorDirectiveDirective,
    ParentComponent,
    ChildComponent,
    BikesComponent,
    BikeDetailsComponent,
    CarsComponent,
    CarDetailsComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot([
      { path: '', component: HomeComponent },
      {
        path: 'about', component: AboutComponent, children: [
          { path: '', component: OmkarComponent },
          { path: 'saif', component: SaifComponent },
          { path: 'suraj', component: SurajComponent },
        ]
      },
      { path: 'login', component: LoginComponent },
      { path: 'register', component: RegisterComponent },
      { path: 'contact-us', component: ContactUsComponent },
      { path: 'late-commers', component: LateCommersComponent },
      { path: 'product-component', component: ProductsComponent },
      { path: 'card-component', component: CardsComponent },
      { path: 'parent-component', component: ParentComponent },
      { path: 'bike-component', component: BikesComponent },
      { path: 'car-component', component: CarsComponent },
      { path: '**', component: PageNotFoundComponent }
    ]

    )],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
