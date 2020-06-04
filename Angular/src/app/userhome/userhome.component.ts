import { Component, OnInit, Input } from '@angular/core';
import { Opportunity } from '../opportunity';
import { OpportunityserviceService } from '../opportunityservice.service';
import {MatSnackBar} from '@angular/material/snack-bar';
import {FormControl, Validators} from '@angular/forms';



@Component({
  selector: 'app-userhome',
  templateUrl: './userhome.component.html',
  styleUrls: ['./userhome.component.css']
})
export class UserhomeComponent implements OnInit {

  Opportunity:Opportunity=new Opportunity(0,"","","",0,0,"","","","");
  message:any;
  responsemessage:string;
  
  constructor(private OpportunityServiceService: OpportunityserviceService,private _snackBar: MatSnackBar) { }
   
  ngOnInit(): void {
    
  }
  email = new FormControl('', [Validators.required, Validators.email]);
 
  getErrorMessage() {
    if (this.email.hasError('required')) {
      return 'You must enter a value';
    }
    return this.email.hasError('email') ? 'Not a valid email' : '';
  }
  public savenow(){
    let resp =this.OpportunityServiceService.dosave(this.Opportunity);
    resp.subscribe((data)=>this.message=data);
    console.log(resp);
    this._snackBar.open("Response:", "Opportunity Added Successfully", {
      duration: 2000,
    });

  }

  


  
  
}
