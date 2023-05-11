import { Component } from '@angular/core';
import { StudyUserSvcService } from './study-user-svc.service';

@Component({
  selector: 'app-study-user',
  templateUrl: './study-user.component.html',
  styleUrls: ['./study-user.component.css']
})
export class StudyUserComponent {

  constructor(private svc: StudyUserSvcService) { }

  public message: String | undefined

  hello() {
    this.svc.hello().subscribe((data: Map<String, String>) => this.message = data.get("message"))

  }
}
