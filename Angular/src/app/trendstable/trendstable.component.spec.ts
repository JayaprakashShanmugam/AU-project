import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TrendstableComponent } from './trendstable.component';

describe('TrendstableComponent', () => {
  let component: TrendstableComponent;
  let fixture: ComponentFixture<TrendstableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TrendstableComponent ]
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
