import { Component} from '@angular/core';
import { SuggestionsService } from 'src/app/services/suggestions.service';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent {
name:any;
topic:any;
suggestion:any;
date:any;
suggestionlist:any;
formattedDate:any;
constructor(private sg:SuggestionsService){

  this.sg.getSuggestions().subscribe({
    next: (data: any) => (this.suggestionlist = data),
    error: () => (this.suggestionlist = [])
  });

  this.date = new Date();
  this.date = new Date();
  const month = this.date.getMonth() + 1;
  const formattedMonth = month < 10 ? `0${month}` : month;
  const formattedDay = this.date.getDate() < 10 ? `0${this.date.getDate()}` : this.date.getDate();
  const formattedYear = this.date.getFullYear();
  this.formattedDate = `${formattedDay}/${formattedMonth}/${formattedYear}`;
  
}

saveSuggestion(){
  var temp:any={
    id: this.suggestionlist.length + 1,
    name: this.name,
    title: this.topic,
    description: this.suggestion,
    created_at:this.formattedDate,
    response:[]
  }
  this.sg.postSuggestion(temp).subscribe(
   { 
    next: (temp:any)=>{
      alert('Your Suggestion is saved');
      console.log(temp)
      location.reload();
    },
    error:(error)=>alert('Unable to save ! some error occured')
  }

  )
}
}
