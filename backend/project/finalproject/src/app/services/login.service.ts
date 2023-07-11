import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  httpOptions:any;
  constructor(private http:HttpClient) { }  
  public addUser(obj:any):Observable<any>{
    this.httpOptions =  new HttpHeaders({
      'Content-Type':  'application/json'
    })

  return this.http.post("http://localhost:4500/users",obj,this.httpOptions);
 }

 public getUser(): Observable<any> {
  return this.http.get("  http://localhost:4500/users");
}
}

