import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { TrendschartComponent } from './trendschart.component';
import { HttpClientTestingModule} from '@angular/common/http/testing';
import { OpportunityserviceService } from '../opportunityservice.service';

describe('TrendschartComponent', () => {
  let component: TrendschartComponent;
  let fixture: ComponentFixture<TrendschartComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports:[HttpClientTestingModule],
      declarations: [ TrendschartComponent ],
      providers:[OpportunityserviceService]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TrendschartComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
