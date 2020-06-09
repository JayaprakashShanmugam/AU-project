import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { OpportunityserviceService } from '../opportunityservice.service';
import { TrendsComponent } from './trends.component';
import { HttpClientTestingModule, HttpTestingController} from '@angular/common/http/testing';

describe('TrendsComponent', () => {
  let component: TrendsComponent;
  let fixture: ComponentFixture<TrendsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports:[HttpClientTestingModule],
      declarations: [ TrendsComponent ],
      providers:[OpportunityserviceService]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TrendsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
