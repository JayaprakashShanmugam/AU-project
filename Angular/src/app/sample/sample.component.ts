import { Component, OnInit,Input } from '@angular/core';
import { OpportunityserviceService } from '../opportunityservice.service';
import { Opportunity } from '../opportunity';
import {MatSnackBar} from '@angular/material/snack-bar';
import {FormControl, Validators} from '@angular/forms';
import {Router} from '@angular/router'


@Component({
  selector: 'app-sample',
  templateUrl: './sample.component.html',
  styleUrls: ['./sample.component.css']
})
export class SampleComponent implements OnInit {
  
  Opportunity:Opportunity=new Opportunity(0,"","","",0,0,"","","","");
  message:any;
  responsemessage:any;
  constructor(private OpportunityServiceService: OpportunityserviceService,private _snackBar: MatSnackBar,private router:Router) { }
 
  oidd:number;
  ngOnInit(): void {
    
    this.oidd=this.OpportunityServiceService.Getid();
    console.log(this.oidd);
    let resp =this.OpportunityServiceService.getbyid(this.oidd);
    resp.subscribe((data)=>this.message=data);
    console.log(resp);
    this._snackBar.open("Response:", "getting details", {
      duration: 2000,
    }); 
   
  }
 
  email = new FormControl('', [Validators.required, Validators.email]);
 
  getErrorMessage() {
    if (this.email.hasError('required')) {
      return 'You must enter a value';
    }
    return this.email.hasError('email') ? 'Not a valid email' : '';
  }
  

 updatenow()
 {
  let resp =this.OpportunityServiceService.updatebyid(this.message);
  resp.subscribe((data)=>this.responsemessage=data);
  console.log(resp);
  this._snackBar.open("Response:", "Opportunity redefined Successfully", {
    duration: 2000,
  });
  this.router.navigateByUrl('/viewtrends');
  
 }


   

  }

 


