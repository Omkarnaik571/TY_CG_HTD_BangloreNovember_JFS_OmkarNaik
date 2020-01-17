import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { HomeComponent } from 'src/app/home/home.component';
import { AboutComponent } from 'src/app/about/about.component';
import { LoginComponent } from 'src/app/login/login.component';
import { RegisterComponent } from 'src/app/register/register.component';
import { LogoutComponent } from 'src/app/logout/logout.component';
import { AdminComponent } from 'src/app/admin/admin.component';
import { AuthGuardService } from 'src/app/auth-guard.service';
import { UserComponent } from 'src/app/user/user.component';
import { PageNotFoundComponent } from 'src/app/page-not-found/page-not-found.component';


let routes = [
    { path: '', component: HomeComponent },
    { path: 'about', component: AboutComponent },
    { path: 'login', component: LoginComponent },
    { path: 'register', component: RegisterComponent },
    { path: 'logout', component: LogoutComponent },
    {
      path: 'admin', component: AdminComponent,
      canActivate: [AuthGuardService], data: { expectedRoles: ['admin'] }
    },
    {
      path: 'user', component: UserComponent,
      canActivate: [AuthGuardService], data: { expectedRoles: ['admin', 'user'] }
    },
    { path: '**', component: PageNotFoundComponent }
  ];



@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule{



}