import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ForumService } from 'src/app/services/forum.service';

@Component({
  selector: 'app-forumpage',
  templateUrl: './forumpage.component.html',
  styleUrls: ['./forumpage.component.css']
})
export class ForumpageComponent {
  forumlist: any;
  value:any;
  question:any;
  id:any;

  constructor(private fs: ForumService) {
    this.fs.getForum().subscribe({
      next: (data: any) => (this.forumlist = data),
      error: () => (this.forumlist = [])
    });
  }
  

  saveQuestion(){

    var temp:any={
      id: this.forumlist.length + 1,
      question: this.question,
      responses: []

    }
    this.fs.postQuestion(temp).subscribe(
     { 
      next: (temp:any)=>{
        alert('Your Question is saved');
        console.log(temp)
        location.reload();
      },
      error:(error)=>alert('Not saved ---some Error')
    }

    )

  }
}
