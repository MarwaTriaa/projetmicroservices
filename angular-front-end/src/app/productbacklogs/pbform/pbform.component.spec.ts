import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PbformComponent } from './pbform.component';

describe('PbformComponent', () => {
  let component: PbformComponent;
  let fixture: ComponentFixture<PbformComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [PbformComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PbformComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
