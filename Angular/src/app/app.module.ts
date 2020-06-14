import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {MatCardModule} from '@angular/material/card';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import { FormsModule, ReactiveFormsModule} from '@angular/forms';
import {MatIconModule} from '@angular/material/icon';
import {MatButtonModule} from '@angular/material/button';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatMenuModule} from '@angular/material/menu';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatRadioModule} from '@angular/material/radio';
import {MatTableModule} from '@angular/material/table';
import {MatPaginatorModule} from '@angular/material/paginator';
import {MatAutocompleteModule} from '@angular/material/autocomplete';
import {MatSortModule} from '@angular/material/sort';
import {MatSelectModule} from '@angular/material/select';
import { SocialLoginModule, AuthServiceConfig, GoogleLoginProvider } from 'angularx-social-login';
import {HttpClientModule,HttpClient,HTTP_INTERCEPTORS} from '@angular/common/http';
import { LoginUserService } from './login-user.service';
import { OpportunityserviceService } from './opportunityservice.service';
import {MatSnackBar,MatSnackBarModule} from '@angular/material/snack-bar';
import {MatDialogModule} from '@angular/material/dialog';
import {RouterModule} from '@angular/router';
import { ChartsModule } from 'ng2-charts';
import { Tokeninterceptor } from './tokeninterceptor';
import { LoginComponent } from './login/login.component';
import { ViewComponent } from './view/view.component';
import { UpdateComponent } from './update/update.component';
import { CreateComponent } from './create/create.component';
import { TrendschartComponent } from './trendschart/trendschart.component';
import { createComponent } from '@angular/compiler/src/core';

const config = new AuthServiceConfig([
  {
    id: GoogleLoginProvider.PROVIDER_ID,
    provider: new GoogleLoginProvider("87799260793-3utvvare40obu3pa17c2sfu1ksvbnlm4.apps.googleusercontent.com")
  }
]);
export function provideConfig() {
  return config;
}



@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ViewComponent,
    UpdateComponent,
    CreateComponent,
    TrendschartComponent
    
  
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    BrowserAnimationsModule,
    MatCardModule,
    MatFormFieldModule,
    MatInputModule,
    FormsModule,
    ReactiveFormsModule,
    MatIconModule,
    MatButtonModule,
    MatToolbarModule,
    MatMenuModule,
    MatDatepickerModule,
    MatRadioModule,
    MatTableModule,
    MatPaginatorModule,
    MatAutocompleteModule,
    MatSortModule,
    MatSelectModule,
    SocialLoginModule,
    HttpClientModule,
    MatDialogModule,
    RouterModule,
    MatSnackBarModule,
    ChartsModule
  ],
  providers: [
    {
      provide: AuthServiceConfig,
      useFactory: provideConfig,
      
    },
    LoginUserService,
    OpportunityserviceService,
    MatSnackBar,
    HttpClient,
    { provide: HTTP_INTERCEPTORS, useClass: Tokeninterceptor, multi: true },
  ],
  bootstrap: [AppComponent],
  entryComponents:[CreateComponent]
})
export class AppModule { }
