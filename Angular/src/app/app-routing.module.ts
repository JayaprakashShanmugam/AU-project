import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginUserComponent } from './login-user/login-user.component';
import { UserhomeComponent } from './userhome/userhome.component';
import { TrendstableComponent } from './trendstable/trendstable.component';


const routes: Routes = [
  {
   path:'login',
   component: LoginUserComponent
  },
  {
    path : 'createtrends',
    component: UserhomeComponent
  },
  {
    path : 'viewtrends',
    component: TrendstableComponent
  },
  {
    path : '',
    component: HomeComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
