import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { SuggestionsService } from 'src/app/services/suggestions.service';

@Component({
  selector: 'app-admin-response',
  templateUrl: './admin-response.component.html',
  styleUrls: ['./admin-response.component.css']
})
export class AdminResponseComponent {
  id:any;
  suggestion:any;
  selected:any;
  constructor(private sg:SuggestionsService,private ar:ActivatedRoute){

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
    this.sg.getSuggestionsbyId(this.id).subscribe({
      next: (data: any) => (this.suggestion = data),
      error: (err) => console.error(err),
    });
  }
}
}
