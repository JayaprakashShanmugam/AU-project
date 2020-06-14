import { Component, OnInit} from '@angular/core';
import { OpportunityserviceService } from '../opportunityservice.service';
import { Opportunity } from '../opportunity';
import {MatSnackBar} from '@angular/material/snack-bar';
import {FormControl, Validators} from '@angular/forms';


@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {

  
  Opportunity:Opportunity=new Opportunity(0,"","","",0,0,"","","","");
  message:any;
  responsemessage:any;
  constructor(private OpportunityServiceService: OpportunityserviceService,private _snackBar: MatSnackBar) { }
 
  oidd:number;
  ngOnInit(): void {
    
    this.oidd=this.OpportunityServiceService.Getid();
    let resp =this.OpportunityServiceService.getbyid(this.oidd);
    resp.subscribe((data)=>this.message=data);
    this._snackBar.open("Response:", "getting details", {
      duration: 2000,
    }); 
   
  }
  oid = new FormControl(0, [Validators.required]);
  description = new FormControl('', [Validators.required]);
  location = new FormControl('', [Validators.required]);
  skills = new FormControl('', [Validators.required]);
  openingcount = new FormControl(0, [Validators.required]);
  projectduration = new FormControl(0, [Validators.required]);
  lastdate = new FormControl('', [Validators.required]);
  experience = new FormControl('', [Validators.required]);
  managername = new FormControl('', [Validators.required]);
  manageremail = new FormControl('', [Validators.required, Validators.email]);
 
  getErrorMessage() {
    if (this.manageremail.hasError('required')) {
      return 'You must enter a value';
    }
    return this.manageremail.hasError('email') ? 'Not a valid email' : '';
  }
  

 updatenow()
 {
  let resp =this.OpportunityServiceService.updatebyid(this.message);
  resp.subscribe((data)=>this.responsemessage=data);
  this._snackBar.open("Response:", "Opportunity redefined Successfully", {
    duration: 2000,
  });
  
  
 }


   

}
