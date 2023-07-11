import { Component } from '@angular/core';
import { ForumService } from 'src/app/services/forum.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-forum-content',
  templateUrl: './forum-content.component.html',
  styleUrls: ['./forum-content.component.css']
})
export class ForumContentComponent {
  id:any;
  Forum:any;
  selected:any;
  constructor(private fs:ForumService,private ar:ActivatedRoute){

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
    this.fs.getForumbyId(this.id).subscribe({
      next: (data: any) => (this.Forum = data),
      error: (err) => console.error(err),
    });
  }
}

user_response:boolean = true;
add_response:boolean = false;

user(){
  this.user_response = true;
  this.add_response= false;
}
own(){
  this.user_response = false;
  this.add_response= true;
}
addResponse(response: string) {
  if (this.Forum && this.Forum.responses) {
    this.Forum.responses.push(response);
    this.fs.updateQuestion(this.Forum).subscribe({
      next: (data: any) => {
        alert('Your response is saved');
        location.reload();
      },
      error: (error) => alert('Not saved ---some Error')
    });
  }
}


}

