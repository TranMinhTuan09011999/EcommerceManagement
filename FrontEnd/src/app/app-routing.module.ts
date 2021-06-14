import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CartComponent } from './cart/cart.component';
import { CheckoutComponent } from './checkout/checkout.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { OrderlistComponent } from './orderlist/orderlist.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { ProductComponent } from './product/product.component';
import { ProductlistComponent } from './productlist/productlist.component';
import { RegisterComponent } from './register/register.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'cart', component: CartComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'cart/checkout', component: CheckoutComponent },
  { path: 'product/:name', component: ProductComponent },
  { path: 'productlist', component: ProductlistComponent },
  { path: 'productlist/:name', component: ProductlistComponent },
  { path: 'orderlist', component: OrderlistComponent },
  /*{ path: '', redirectTo: 'productlist', pathMatch: 'full' },*/
  // { path: '**', component: PageNotFoundComponent},
  { path: '', redirectTo: 'admin', pathMatch: 'full' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
