import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { SuggestionsService } from 'src/app/services/suggestions.service';

@Component({
  selector: 'app-response-form',
  templateUrl: './response-form.component.html',
  styleUrls: ['./response-form.component.css']
})
export class ResponseFormComponent {
response:any;
suggestionlist:any;
id:any;
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
      next: (data: any) => {
        this.suggestionlist = data;
        console.log(data);
      },
      error: (err) => console.error(err),
    });
  }
}



adminResponse(temp:string){
  if (this.suggestionlist && this.suggestionlist.response) {
    this.suggestionlist.response.push(temp);
    this.sg.postComment(this.suggestionlist).subscribe({
      next: (data: any) => {
        alert('Your response is saved');
        location.reload();
      },
      error: (error) => alert('Not saved ---some Error')
    });
  }
  else{
    alert('Error')
  }
}
}
