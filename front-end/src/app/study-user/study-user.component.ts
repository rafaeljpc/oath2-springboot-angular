import { Component } from '@angular/core';
import { StudyUserSvcService } from './study-user-svc.service';
import { Observable, catchError, filter, map, of, tap } from 'rxjs';

@Component({
  selector: 'app-study-user',
  templateUrl: './study-user.component.html',
  styleUrls: ['./study-user.component.css']
})
export class StudyUserComponent {

  constructor(private svc: StudyUserSvcService) { }

  public message$: Observable<String> = of("")

  hello() {
    this.message$ = this.svc.hello().pipe(map(v => v.message))
  }
}