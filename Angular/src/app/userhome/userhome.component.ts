import { Component, OnInit, Input } from '@angular/core';
import {MatSelectModule} from '@angular/material/select';




@Component({
  selector: 'app-userhome',
  templateUrl: './userhome.component.html',
  styleUrls: ['./userhome.component.css']
})
export class UserhomeComponent implements OnInit {

  
    
  constructor() { }

  
  
   
  ngOnInit(): void {
    
  }
 
  onCreate()
  {
    alert("Trend created Successfully");
  }


  
  
}
