import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class LoginUserService {
 
  constructor(private http:HttpClient) { }
  
  public dosaveuser(firstname:string,lastname:string,email:string)
  {
     return this.http.get("http://localhost:8080/adduser/"+firstname+"/"+lastname+"/"+email)
  }
}
  