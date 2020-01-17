import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { HttpClientModule} from '@angular/common/http';
import { FormsModule } from '@angular/forms';




import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { AddProductComponent } from './add-product/add-product.component';
import { DataFromJsonComponent } from './data-from-json/data-from-json.component';
import { DataFromJSONPracticeComponent } from './data-from-jsonpractice/data-from-jsonpractice.component';
import { AddProductPracticeComponent } from './add-product-practice/add-product-practice.component';
import { GetProductsComponent } from './get-products/get-products.component';
import { EditProductComponent } from './edit-product/edit-product.component';
import { UserComponent } from './user/user.component';
import { AuthGuard } from './home/auth.guard';
import { CutStringPipe } from './cut-string.pipe';
import { FilterProductsPipe } from './filter-products.pipe';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    AddProductComponent,
    DataFromJsonComponent,
    DataFromJSONPracticeComponent,
    AddProductPracticeComponent,
    GetProductsComponent,
    EditProductComponent,
    UserComponent,
    CutStringPipe,
    FilterProductsPipe
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot([
      { path: '', component: HomeComponent },
      { path: 'product-component', component: AddProductComponent },
      { path: 'data-from-json', component: DataFromJsonComponent },
      { path: 'data-from-json-practice', component: DataFromJSONPracticeComponent },
      { path: 'add-product-practice', component: AddProductPracticeComponent ,
       canActivate:[AuthGuard], data:{name : 'Omkar'} },
      { path: 'get-product', component: GetProductsComponent },
      { path: 'edit-product', component: EditProductComponent },
      { path: 'user-component/:id', component: UserComponent }
    ])
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
