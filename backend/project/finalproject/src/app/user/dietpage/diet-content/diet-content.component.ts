import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { DietplanService } from 'src/app/services/dietplan.service';

@Component({
  selector: 'app-diet-content',
  templateUrl: './diet-content.component.html',
  styleUrls: ['./diet-content.component.css']
})
export class DietContentComponent {
  id:any;
  product:any
  constructor(private dt:DietplanService,private ar:ActivatedRoute){

    this.ar.params.subscribe(              
      {
        next: (params)=>{ 
         this.id =params['id']
         this.readData()
        },
        error: () => this.id = 0
      }
    )
 }

 readData() {
  if (this.id) {
    this.dt.getDietsbyId(this.id).subscribe({
      next: (data: any) => (this.product = data),
      error: (err) => console.error(err),
    });
  }
}

}
