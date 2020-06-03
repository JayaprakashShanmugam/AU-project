import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Injectable({
  providedIn: 'root'
})
export class OpportunityserviceService {

  constructor(private http:HttpClient ) { }

  
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
  
}
