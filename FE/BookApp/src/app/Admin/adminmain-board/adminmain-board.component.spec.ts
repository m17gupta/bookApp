import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminmainBoardComponent } from './adminmain-board.component';

describe('AdminmainBoardComponent', () => {
  let component: AdminmainBoardComponent;
  let fixture: ComponentFixture<AdminmainBoardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminmainBoardComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdminmainBoardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
