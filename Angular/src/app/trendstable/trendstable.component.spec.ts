import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { OpportunityserviceService } from '../opportunityservice.service';
import { TrendstableComponent } from './trendstable.component';
import { HttpClientTestingModule, HttpTestingController} from '@angular/common/http/testing';
import {MatSnackBar, MatSnackBarModule} from '@angular/material/snack-bar';
import {MatDialogModule,MatDialog} from '@angular/material/dialog';



describe('TrendstableComponent', () => {
  let component: TrendstableComponent;
  let fixture: ComponentFixture<TrendstableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports:[HttpClientTestingModule,MatSnackBarModule,MatDialogModule],
      declarations: [ TrendstableComponent ],
      providers:[OpportunityserviceService,MatSnackBar,MatDialog]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TrendstableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
