import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BnbLoginComponent } from './bnb-login.component';

describe('BnbLoginComponent', () => {
  let component: BnbLoginComponent;
  let fixture: ComponentFixture<BnbLoginComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BnbLoginComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BnbLoginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
