import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddProductComponent } from './add-product/add-product.component';
import { AddLandComponent } from './add-land/add-land.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { SignupComponent } from './signup/signup.component';
import { AdminComponent } from './admin/admin.component';
import { AddContractComponent } from './add-contract/add-contract.component';
import { OtherContractOperationComponent } from './other-contract-operation/other-contract-operation.component';
import { OtherCustomerOperationComponent } from './other-customer-operation/other-customer-operation.component';
import { OtherLandOperationComponent } from './other-land-operation/other-land-operation.component';
import { OtherProductOperationComponent } from './other-product-operation/other-product-operation.component';
import { AddCustomerComponent } from './add-customer/add-customer.component';
import { EditContractComponent } from './edit-contract/edit-contract.component';
import { EditCustomerComponent } from './edit-customer/edit-customer.component';
import { AccountsOperationComponent } from './accounts-operation/accounts-operation.component';
import { EditAccountComponent } from './edit-account/edit-account.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { EditProductComponent } from './edit-product/edit-product.component';
import { EditLandComponent } from './edit-land/edit-land.component';
import { ClientComponent } from './client/client.component';
import { SchedulerComponent } from './scheduler/scheduler.component';
import { ClientOtherContractOpeartionComponent } from './client-other-contract-opeartion/client-other-contract-opeartion.component';
import { ClientOtherCustomerOpeartionComponent } from './client-other-customer-opeartion/client-other-customer-opeartion.component';
import { ClientEditContractComponent } from './client-edit-contract/client-edit-contract.component';
import { SchedulerEditContractComponent } from './scheduler-edit-contract/scheduler-edit-contract.component';
import { ClientEditCustomerComponent } from './client-edit-customer/client-edit-customer.component';
import { ClientAddContractComponent } from './client-add-contract/client-add-contract.component';
import { SchedulerOtherContractComponent } from './scheduler-other-contract/scheduler-other-contract.component';
import { AuthGuardService } from './auth-guard.service';
import { Login2Component } from './login2/login2.component';
import { DemoComponent } from './demo/demo.component';


const routes: Routes = [
  {path: '', component: HomeComponent},
  // {path: 'login', component: LoginComponent},
  {path: 'login', component: Login2Component},
  {path: 'demo', component: DemoComponent},
  {path: 'logout', component: LogoutComponent},
  {path: 'signup', component: SignupComponent},
  {path: 'admin', component: AdminComponent, canActivate: [AuthGuardService],data: {type: 'admin'}},
  {path: 'client', component: ClientComponent,canActivate: [AuthGuardService],data: {type: 'client'}},
  {path: 'scheduler', component: SchedulerComponent,canActivate: [AuthGuardService],data: {type: 'scheduler'}},
  {path: 'addContract', component: AddContractComponent},
  {path: 'clientAddContract', component: ClientAddContractComponent},
  {path: 'other-contract-operation', component: OtherContractOperationComponent},
  {path: 'editContract/:contractNo', component: EditContractComponent},
  {path: 'clientEditContract/:contractNo', component: ClientEditContractComponent},
  {path: 'schedulerEditContract/:contractNo', component: SchedulerEditContractComponent},
  {path: 'editProduct/:productId', component: EditProductComponent},
  {path: 'editAccount/:userName', component: EditAccountComponent},
  {path: 'editLand/:plotNumber', component: EditLandComponent},
  {path: 'other-customer-operation', component: OtherCustomerOperationComponent},
  {path: 'editCustomer/:customerId', component: EditCustomerComponent },
  {path: 'clientEditCustomer/:customerId', component: ClientEditCustomerComponent },
  {path: 'other-land-operation', component: OtherLandOperationComponent},
  {path: 'other-product-operation', component: OtherProductOperationComponent},
  {path: 'client-other-contract-operation', component: ClientOtherContractOpeartionComponent},
  {path: 'scheduler-other-contract-operation', component: SchedulerOtherContractComponent},
  {path: 'client-other-customer-operation', component: ClientOtherCustomerOpeartionComponent},
  {path: 'addCustomer', component: AddCustomerComponent},
  {path: 'addLand', component: AddLandComponent},
  {path: 'addProduct', component: AddProductComponent},
  {path: 'account-operation', component: AccountsOperationComponent},
  {path: '**', component: PageNotFoundComponent}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
