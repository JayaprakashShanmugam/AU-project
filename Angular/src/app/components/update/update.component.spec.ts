import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { UpdateComponent } from './update.component';
import { HttpClientTestingModule} from '@angular/common/http/testing';
import {MatSnackBar, MatSnackBarModule} from '@angular/material/snack-bar';
import { OpportunityserviceService } from '../opportunityservice.service';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BrowserTestingModule } from '@angular/platform-browser/testing';


describe('UpdateComponent', () => {
  let component: UpdateComponent;
  let fixture: ComponentFixture<UpdateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports:[HttpClientTestingModule,MatSnackBarModule,BrowserTestingModule,BrowserAnimationsModule],
      declarations: [ UpdateComponent ],
      providers:[OpportunityserviceService,MatSnackBar]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
