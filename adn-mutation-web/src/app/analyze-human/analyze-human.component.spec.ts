import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AnalyzeHumanComponent } from './analyze-human.component';

describe('AnalyzeHumanComponent', () => {
  let component: AnalyzeHumanComponent;
  let fixture: ComponentFixture<AnalyzeHumanComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AnalyzeHumanComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AnalyzeHumanComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
