import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddContractComponent } from './add-contract/add-contract.component';
import { AddCustomerComponent } from './add-customer/add-customer.component';
import { AddLandComponent } from './add-land/add-land.component';
import { AddProductComponent } from './add-product/add-product.component';
import { AdminComponent } from './admin/admin.component';
import { FooterComponent } from './footer/footer.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { OtherContractOperationComponent } from './other-contract-operation/other-contract-operation.component';
import { OtherCustomerOperationComponent } from './other-customer-operation/other-customer-operation.component';
import { OtherLandOperationComponent } from './other-land-operation/other-land-operation.component';
import { OtherProductOperationComponent } from './other-product-operation/other-product-operation.component';
import { SignupComponent } from './signup/signup.component';
import { EditContractComponent } from './edit-contract/edit-contract.component';
import { EditCustomerComponent } from './edit-customer/edit-customer.component';
import { AccountsOperationComponent } from './accounts-operation/accounts-operation.component';
import { EditAccountComponent } from './edit-account/edit-account.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { EditProductComponent } from './edit-product/edit-product.component';
import { EditLandComponent } from './edit-land/edit-land.component';
import { ClientComponent } from './client/client.component';
import { SchedulerComponent } from './scheduler/scheduler.component';
import { ClientOtherCustomerOpeartionComponent } from './client-other-customer-opeartion/client-other-customer-opeartion.component';
import { ClientOtherContractOpeartionComponent } from './client-other-contract-opeartion/client-other-contract-opeartion.component';
import { ClientEditContractComponent } from './client-edit-contract/client-edit-contract.component';
import { ClientEditCustomerComponent } from './client-edit-customer/client-edit-customer.component';
import { SchedulerEditContractComponent } from './scheduler-edit-contract/scheduler-edit-contract.component';
import { ClientAddContractComponent } from './client-add-contract/client-add-contract.component';
import { SchedulerOtherContractComponent } from './scheduler-other-contract/scheduler-other-contract.component';

@NgModule({
  declarations: [
    AppComponent,
    AddContractComponent,
    AddCustomerComponent,
    AddLandComponent,
    AddProductComponent,
    AdminComponent,
    FooterComponent,
    HeaderComponent,
    HomeComponent,
    LoginComponent,
    LogoutComponent,
    OtherContractOperationComponent,
    OtherCustomerOperationComponent,
    OtherLandOperationComponent,
    OtherProductOperationComponent,
    SignupComponent,
    EditContractComponent,
    EditCustomerComponent,
    AccountsOperationComponent,
    EditAccountComponent,
    PageNotFoundComponent,
    EditProductComponent,
    EditLandComponent,
    ClientComponent,
    SchedulerComponent,
    ClientOtherCustomerOpeartionComponent,
    ClientOtherContractOpeartionComponent,
    ClientEditContractComponent,
    ClientEditCustomerComponent,
    SchedulerEditContractComponent,
    ClientAddContractComponent,
    SchedulerOtherContractComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
