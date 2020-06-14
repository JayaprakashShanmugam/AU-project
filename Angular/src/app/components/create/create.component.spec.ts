import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { CreateComponent } from './create.component';
import { OpportunityserviceService } from '../opportunityservice.service';
import { HttpClientTestingModule} from '@angular/common/http/testing';
import {MatSnackBar, MatSnackBarModule} from '@angular/material/snack-bar';
import {FormGroup,FormBuilder} from '@angular/forms';


describe('CreateComponent', () => {
  let component: CreateComponent;
  let fixture: ComponentFixture<CreateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CreateComponent ],
      imports:[MatSnackBarModule,HttpClientTestingModule],
      providers:[OpportunityserviceService,MatSnackBar,FormBuilder]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
  it('form invalid when empty', () => {
    expect(component.form.valid).toBeFalsy();
  });
 
  it('oid field validity', () => {
    let oid = component.form.controls['oid'];
    expect(oid.valid).toBeFalsy(); 
  });
  it('description field validity', () => {
    let description = component.form.controls['description'];
    expect(description.valid).toBeFalsy(); 
  });
  it('location field validity', () => {
    let location = component.form.controls['location'];
    expect(location.valid).toBeFalsy(); 
  });
  it('skills field validity', () => {
    let skills = component.form.controls['skills'];
    expect(skills.valid).toBeFalsy(); 
  });
  it('openingcount field validity', () => {
    let openingcount = component.form.controls['openingcount'];
    expect(openingcount.valid).toBeFalsy();
  });
  it('projectduration field validity', () => {
    let projectduration = component.form.controls['projectduration'];
    expect(projectduration.valid).toBeFalsy(); 
  });
  it('lastdate field validity', () => {
    let lastdate = component.form.controls['lastdate'];
    expect(lastdate.valid).toBeFalsy(); 
  });
  it('experience field validity', () => {
    let experience = component.form.controls['experience'];
    expect(experience.valid).toBeFalsy(); 
  });
  it('managername field validity', () => {
    let managername = component.form.controls['managername'];
    expect(managername.valid).toBeFalsy(); 
  });
  it('manageremail field validity', () => {
    let manageremail = component.form.controls['manageremail'];
    expect(manageremail.valid).toBeFalsy(); 
  });
  it('manageremail field validity', () => {
    let errors = {};
    let manageremail = component.form.controls['manageremail'];
    errors = manageremail.errors || {};
    expect(errors['required']).toBeTruthy(); 
  });
  it('manageremail field check', () => {
    let errors = {};
    let manageremail = component.form.controls['manageremail'];
    manageremail.setValue("test");
    errors = manageremail.errors || {};
    expect(errors['pattern']).toBeTruthy();
  });
  it('submitting a form opportunity', () => {
    expect(component.form.valid).toBeFalsy();
    component.form.controls['oid'].setValue(1);
    component.form.controls['description'].setValue("Software Engineer");
    component.form.controls['location'].setValue("Chennai");
    component.form.controls['skills'].setValue("Testing Developer");
    component.form.controls['openingcount'].setValue(12);
    component.form.controls['projectduration'].setValue(30);
    component.form.controls['lastdate'].setValue("13-03-2019");
    component.form.controls['experience'].setValue("3 years");
    component.form.controls['managername'].setValue("test");
    component.form.controls['manageremail'].setValue("test@accoliteindia.com");
    expect(component.form.valid).toBeTruthy;
    
  })

});
