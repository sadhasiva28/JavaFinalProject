import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TranslateService } from '@ngx-translate/core';




@Component({
  selector: 'app-toolbar',
  templateUrl: './toolbar.component.html',
  styleUrls: ['./toolbar.component.css']
})
export class ToolbarComponent {
  lang:any="english"
  languages:any=[
    {name:"English",value:"english"},
    {name:"Telugu",value:"telugu"},
    {name:"Tamil",value:"tamil"},
    {name:"Hindi",value:"hindi"},
    {name:"Kannada",value:"kannada"},
    {name:"Malayalam",value:"malayalam"},
    {name:"Marati",value:"marati"}
  ]
  constructor(private router:Router,private ar:ActivatedRoute, private ts:TranslateService){
    this.ts.use(this.lang)
  }
  home(){
    this.router.navigate(['home'],{relativeTo:this.ar})
  }
  changeLang(langValue: string): void {
    this.lang = langValue; 
    this.ts.use(langValue); 
  }
  
}
