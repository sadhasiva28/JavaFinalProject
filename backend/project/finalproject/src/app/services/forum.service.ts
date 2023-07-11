import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ForumService {
  httpOptions: any;

  constructor(private http: HttpClient) { }

  public getForum(): Observable<any> {
    return this.http.get("http://localhost:4500/Forum");
  }

  public getForumbyId(id: any): Observable<any> {
    return this.http.get("http://localhost:4500/Forum/" + id);
  }

  public postQuestion(obj: any): Observable<any> {
    this.httpOptions = new HttpHeaders({
      'Content-Type': 'application/json',
    })

    return this.http.post("http://localhost:4500/Forum", obj, this.httpOptions);
  }

  public updateQuestion(obj: any): Observable<any> {
    const httpResponses = new HttpHeaders({
      'Content-Type':  'application/json'
    });
    return this.http.put("http://localhost:4500/Forum/"+obj.id, obj, {headers: httpResponses});
  }
}
