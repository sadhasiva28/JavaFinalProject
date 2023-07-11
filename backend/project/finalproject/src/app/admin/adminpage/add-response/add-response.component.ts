import { Component } from '@angular/core';
import { SuggestionsService } from 'src/app/services/suggestions.service';

@Component({
  selector: 'app-add-response',
  templateUrl: './add-response.component.html',
  styleUrls: ['./add-response.component.css']
})
export class AddResponseComponent {

  suggestionlist:any;

  constructor(private sg: SuggestionsService) {
    this.sg.getSuggestions().subscribe({
      next: (data: any) => (this.suggestionlist = data),
      error: (err) => this.suggestionlist = [],
    });
  }
}
