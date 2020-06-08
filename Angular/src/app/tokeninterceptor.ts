import { Injectable } from '@angular/core';
import { HttpEvent, HttpInterceptor, HttpHandler, HttpRequest } from '@angular/common/http';
import { Observable } from 'rxjs';
import { LoginUserService } from './login-user.service';


@Injectable()
export class Tokeninterceptor implements HttpInterceptor {
 private service : LoginUserService;
 usertoken : string 
 intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
     this.usertoken = localStorage.getItem('idtoken');
    const modifiedReq = req.clone({ 
      headers: req.headers.set('Authorization', this.usertoken),
    });
    return next.handle(modifiedReq);
  }
}