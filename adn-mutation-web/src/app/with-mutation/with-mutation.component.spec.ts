import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WithMutationComponent } from './with-mutation.component';

describe('WithMutationComponent', () => {
  let component: WithMutationComponent;
  let fixture: ComponentFixture<WithMutationComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WithMutationComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(WithMutationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
