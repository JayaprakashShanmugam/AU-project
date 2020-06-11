import { Injectable } from '@angular/core';
import { HttpEvent, HttpInterceptor, HttpHandler, HttpRequest,HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { LoginUserService } from './login-user.service';


@Injectable()
export class Tokeninterceptor implements HttpInterceptor {
 private service : LoginUserService;
 usertoken : string ;
 emailid : string;
 intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
     this.usertoken = localStorage.getItem('idtoken');
     this.emailid = localStorage.getItem('useremail');
     const modifiedReq = req.clone({
      headers: new HttpHeaders({
        'authtoken': this.usertoken,
        'authemail': this.emailid
      })
    });
    return next.handle(modifiedReq);
  }
}