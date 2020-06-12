import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginUserComponent } from './components/login-user/login-user.component';
import { UserhomeComponent } from './components/userhome/userhome.component';
import { TrendstableComponent } from './components/trendstable/trendstable.component';
import { SampleComponent } from './components/sample/sample.component';
import { TrendsComponent } from './components/trends/trends.component'


const routes: Routes = [
  {
   path:'home',
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
    path : 'trends',
    component: TrendsComponent 
  },

  
  {
    path : 'getid',
    component: SampleComponent
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
