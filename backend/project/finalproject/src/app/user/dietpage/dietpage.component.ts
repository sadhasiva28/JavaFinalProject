import { Component } from '@angular/core';
import { DietplanService } from 'src/app/services/dietplan.service';

@Component({
  selector: 'app-dietpage',
  templateUrl: './dietpage.component.html',
  styleUrls: ['./dietpage.component.css']
})
export class DietpageComponent {
  Dietlist: any;
  constructor(private ds: DietplanService) {
    this.ds.getDiets().subscribe({
      next: (data: any) => (this.Dietlist = data),
      error: () => (this.Dietlist = [])
    });
  }

}
