import { Component, OnInit } from '@angular/core';
import { RestService } from './rest.service';
import { environment } from '../environments/environment'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  message: string
  userInfo: string
  env: string
  constructor(private rest: RestService) { 
  }

  ngOnInit() {
    if (environment.production){
      this.env = 'Running in Production mode';
    }else{
      this.env = 'Running in Development mode';
    }

    this.loadData();
  }

  loadData(){
    this.rest.getMessage('hello').subscribe((data: any) => {
      this.message = data;
    });

    this.rest.getMessage('userInfo').subscribe((data: any) => {
      this.userInfo = data;
    });
  }
  
  handleClick(event: any){
    this.loadData();
	  alert('ok!');
  }

}
