import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { LoginUserComponent } from './login-user.component';
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
describe('LoginUserComponent', () => {
  let component: LoginUserComponent;
  let fixture: ComponentFixture<LoginUserComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [
        ReactiveFormsModule,
        FormsModule,
        MatSnackBarModule,
        HttpClientTestingModule
        
    ],
      declarations: [ LoginUserComponent ],
      providers: [ {provide: AuthService,AuthServiceConfig, useFactory: provideConfig } ,MatSnackBar,FormBuilder],
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LoginUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
