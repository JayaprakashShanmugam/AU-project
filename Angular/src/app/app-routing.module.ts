import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { ViewComponent } from './view/view.component';
import { UpdateComponent } from './update/update.component';
import { CreateComponent } from './create/create.component';
import { TrendschartComponent } from './trendschart/trendschart.component';


const routes: Routes = [
  {
   path:'home',
   component: LoginComponent
  },
  {
    path : 'createtrends',
    component: CreateComponent
  },
  {
    path : 'viewtrends',
    component: ViewComponent
  },
  {
    path : 'trendschart',
    component: TrendschartComponent
  },
  {
    path : 'updatetrends',
    component: UpdateComponent
  },
 
  
  
  {
    path : '',
    redirectTo:'home ',
    pathMatch:'full'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
