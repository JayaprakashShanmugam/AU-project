import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../environments/environment';


@Injectable({
  providedIn: 'root'
})
export class OpportunityserviceService {

  constructor(private http:HttpClient ) { }
  oid:number=0;
 
 
 public Setid(oid:number):void
 {
    this.oid=oid;
 }

 public Getid():number
  {
    
     return this.oid;
  }
  
  public dosave(Opportunity)
  {
    
     return this.http.post(environment.baseUrl+"addopp",Opportunity,{responseType:'text' as 'json'})
  }
  public getopportunity()
  {
    return this.http.get(environment.baseUrl+"getoppurtunities");
  }

  public deleteopportunity(oid)
  {
    return this.http.delete(environment.baseUrl+"deleteopportunity/"+oid);
  }

  public getbyid(oid)
  {
    return this.http.get(environment.baseUrl+"getopportunityid/"+oid);
  }
  public updatebyid(Opportunity)
  {
    return this.http.put(environment.baseUrl+"updatebyid/",Opportunity,{responseType:'text' as 'json'})
  }
  
}
