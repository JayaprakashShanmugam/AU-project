import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../environments/environment';



@Injectable({
  providedIn: 'root'
})
export class LoginUserService {
 

  constructor(private http:HttpClient) { }
  
  
  public dosaveuser(firstname:string,lastname:string,email:string)
  {
     return this.http.get(environment.baseUrl+"validateuser/"+firstname+"/"+lastname+"/"+email);
  }
 
 

}


  