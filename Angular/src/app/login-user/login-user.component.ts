import { Component, OnInit, Output, Input } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { AuthService, GoogleLoginProvider, SocialUser } from 'angularx-social-login';
import { LoginUserService } from '../login-user.service';
import {MatSnackBar} from '@angular/material/snack-bar';

@Component({
  selector: 'app-login-user',
  templateUrl: './login-user.component.html',
  styleUrls: ['./login-user.component.css']
})
export class LoginUserComponent implements OnInit {
  signinForm: FormGroup;
  user: SocialUser;
  loggedIn: boolean;    
  message:any;
  constructor(private fb: FormBuilder, private authService: AuthService, private loginservice:LoginUserService, private _snackBar: MatSnackBar){}
  
  ngOnInit(): void {
    
    this.signinForm = this.fb.group({
      email: ['', Validators.required],
      password: ['', Validators.required]
    });    this.authService.authState.subscribe((user) => {
      this.user = user;
      this.loggedIn = (user != null);
      
    });
    
  }
  

  
  signInWithGoogle(): void {
    this.authService.signIn(GoogleLoginProvider.PROVIDER_ID);
    
  }
  signOut(): void {
    
    this.authService.signOut();
    localStorage.removeItem('idtoken');
  }

  rememberuser() : void
  {
    
    localStorage.setItem('idtoken',this.user.id);
    console.log("your google id was:"+this.user.id)
    console.log(this.user.id);
    let resp= this.loginservice.dosaveuser(this.user.firstName,this.user.lastName,this.user.email);
    resp.subscribe((data)=>this.message=data);
    this._snackBar.open("Response:","Synced with Server", {
      duration: 2000,
    }); 
    
  }

  
   
   
  
}
