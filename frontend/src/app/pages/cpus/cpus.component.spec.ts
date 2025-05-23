import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CpusComponent } from './cpus.component';

describe('CpusComponent', () => {
  let component: CpusComponent;
  let fixture: ComponentFixture<CpusComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CpusComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CpusComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
