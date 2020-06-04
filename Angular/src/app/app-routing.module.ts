import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginUserComponent } from './login-user/login-user.component';
import { UserhomeComponent } from './userhome/userhome.component';
import { TrendstableComponent } from './trendstable/trendstable.component';
import { SampleComponent } from './sample/sample.component';


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
    path : 'restapi',
    component: SampleComponent
  },
  {
    path : 'home',
    component: HomeComponent
  },
  
  
  {
    path : '',
    redirectTo:'home',
    pathMatch:'full'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
