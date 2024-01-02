import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductbacklogsComponent } from './productbacklogs.component';

describe('ProductbacklogsComponent', () => {
  let component: ProductbacklogsComponent;
  let fixture: ComponentFixture<ProductbacklogsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ProductbacklogsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ProductbacklogsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
