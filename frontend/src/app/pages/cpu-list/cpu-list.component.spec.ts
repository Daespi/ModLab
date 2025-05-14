import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CpuListComponent } from './cpu-list.component';

describe('CpuListComponent', () => {
  let component: CpuListComponent;
  let fixture: ComponentFixture<CpuListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CpuListComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CpuListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
