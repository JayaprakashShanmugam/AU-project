import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { OpportunityserviceService } from '../../services/opportunityservice.service';
import { TrendstableComponent } from './trendstable.component';
import { HttpClientTestingModule} from '@angular/common/http/testing';
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
  it('should filter the dataSource', async(() => {

    fixture.detectChanges();
    component.applyFilter('Software');
    expect(component.dataSource.filter).toBe('software');
    expect(component.dataSource.filter.length).toBe(8);
    component.applyFilter('App Developer');
    expect(component.dataSource.filter).toBe('app developer');
    expect(component.dataSource.filter.length).toBe(13);
    component.applyFilter('Java');
    expect(component.dataSource.filter).toBe('java');
    expect(component.dataSource.filter.length).toBe(4);
  }));

});
