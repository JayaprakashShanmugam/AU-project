import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Opportunity } from './opportunity';


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
    
     return this.http.post("http://localhost:8080/addopp",Opportunity,{responseType:'text' as 'json'})
  }
  public getopportunity()
  {
    return this.http.get("http://localhost:8080/getoppurtunities");
  }

  public deleteopportunity(oid)
  {
    return this.http.delete("http://localhost:8080/deleteopportunity/"+oid);
  }

  public getbyid(oid)
  {
    return this.http.get("http://localhost:8080/getopportunityid/"+oid);
  }
  public updatebyid(Opportunity)
  {
    return this.http.put("http://localhost:8080/updatebyid/",Opportunity,{responseType:'text' as 'json'})
  }
  
}
