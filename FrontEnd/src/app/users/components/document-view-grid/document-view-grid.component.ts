import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import 'rxjs/Rx';
import { Observer } from 'rxjs/Observer';

@Component({
  selector: 'app-document-view-grid',
  templateUrl: './document-view-grid.component.html',
  styleUrls: ['./document-view-grid.component.css']
})
export class DocumentViewGridComponent implements OnInit {
child2;
  constructor() { }

  ngOnInit(): void {
   
    const obser = Observable.create((observer: Observer<any>) => {
      setTimeout(() => {
        observer.next([1, 2, 4, 5]);
      }, 2000);
    });
    obser.subscribe((data: any) =>{
      console.log(data);
      this.child2 = data;
    }
    );

  }

}