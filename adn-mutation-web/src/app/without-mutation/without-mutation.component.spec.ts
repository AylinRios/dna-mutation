import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WithoutMutationComponent } from './without-mutation.component';

describe('WithoutMutationComponent', () => {
  let component: WithoutMutationComponent;
  let fixture: ComponentFixture<WithoutMutationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WithoutMutationComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(WithoutMutationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
