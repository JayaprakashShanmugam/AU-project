import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { OpportunityserviceService } from '../opportunityservice.service';
import { UserhomeComponent } from './userhome.component';
import { HttpClientTestingModule, HttpTestingController} from '@angular/common/http/testing';
import {MatSnackBar, MatSnackBarModule} from '@angular/material/snack-bar';



describe('UserhomeComponent', () => {
  let component: UserhomeComponent;
  let fixture: ComponentFixture<UserhomeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserhomeComponent ],
      imports:[MatSnackBarModule,HttpClientTestingModule],
      providers:[OpportunityserviceService,MatSnackBar]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserhomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
