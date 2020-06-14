import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { LoginComponent } from './login.component';
import { AuthServiceConfig, GoogleLoginProvider, AuthService } from 'angularx-social-login';
import { FormsModule, ReactiveFormsModule ,FormBuilder} from '@angular/forms';
import {MatSnackBar,MatSnackBarModule} from '@angular/material/snack-bar';
import { HttpClientTestingModule} from '@angular/common/http/testing';

const config = new AuthServiceConfig([
  {
    id: GoogleLoginProvider.PROVIDER_ID,
    provider: new GoogleLoginProvider("87799260793-3utvvare40obu3pa17c2sfu1ksvbnlm4.apps.googleusercontent.com")
  }
]);
export function provideConfig() {
  return config;
}

describe('LoginComponent', () => {
  let component: LoginComponent;
  let fixture: ComponentFixture<LoginComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [
        ReactiveFormsModule,
        FormsModule,
        MatSnackBarModule,
        HttpClientTestingModule
        
    ],
      declarations: [ LoginComponent ],
      providers: [ {provide: AuthService,AuthServiceConfig, useFactory: provideConfig } ,MatSnackBar,FormBuilder],
   
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
