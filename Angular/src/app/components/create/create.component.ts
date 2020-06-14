import { Component, OnInit, } from '@angular/core';
import { Opportunity } from '../opportunity';
import { OpportunityserviceService } from '../opportunityservice.service';
import {MatSnackBar} from '@angular/material/snack-bar';
import {FormGroup,FormControl, Validators,FormBuilder} from '@angular/forms';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {
  Opportunity:Opportunity=new Opportunity(0,"","","",0,0,"","","","");
  message:any;
  responsemessage:string;
  form: FormGroup;
  constructor(private OpportunityServiceService: OpportunityserviceService,private _snackBar: MatSnackBar,private fb: FormBuilder) { }
   
  ngOnInit(): void {
    this.form = this.fb.group({
      oid: ['', [
        Validators.required]],
      description: ['', [
        Validators.required]],
      location: ['', [
        Validators.required]],
      skills: ['', [
        Validators.required]],
      openingcount: ['', [
        Validators.required]],
      projectduration: ['', [
        Validators.required]],
      lastdate: ['', [
        Validators.required]],
      experience: ['', [
        Validators.required]],
      managername: ['', [
        Validators.required]],
      manageremail: ['', [
        Validators.required,
        Validators.email,
        Validators.pattern("[^ @]*@[^ @]*")]]

    });
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
    this._snackBar.open("Response:", "Opportunity Added Successfully", {
      duration: 2000,
    });
  }
    


}
