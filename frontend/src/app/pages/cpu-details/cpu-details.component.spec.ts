import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CpuDetailComponent } from './cpu-details.component';


describe('CpuDetailsComponent', () => {
  let component: CpuDetailComponent;
  let fixture: ComponentFixture<CpuDetailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CpuDetailComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CpuDetailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
