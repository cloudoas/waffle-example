import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

// for cross origin deployment
//const endpoint = 'http://localhost:8080/';

// for same origin deployment
const endpoint = '/api/';

@Injectable({
    providedIn: 'root'
})
export class RestService {
    constructor(private http: HttpClient) { }

    getMessage(path: string): Observable<any> {
        return this.http.get(endpoint + path, {responseType: 'text'});
    }
}