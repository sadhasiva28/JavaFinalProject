import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SuggestionsService {
  httpOptions:any;
  constructor(private http: HttpClient) { }

  public getSuggestions(): Observable<any> {
    return this.http.get("http://localhost:4500/suggestions");
  }

  public getSuggestionsbyId(id:any): Observable<any> {
    return this.http.get("http://localhost:4500/suggestions/"+id);
  }

  public postComment(obj: any): Observable<any> {
    const httpResponses = new HttpHeaders({
      'Content-Type':  'application/json'
    });
    return this.http.put("http://localhost:4500/suggestions/"+obj.id, obj, {headers: httpResponses});
  }

  public postSuggestion(obj:any):Observable<any>{
    this.httpOptions = new HttpHeaders({
      'Content-Type': 'application/json',
    })

    return this.http.post("http://localhost:4500/suggestions/", obj, this.httpOptions);
  }
}
