import {Component, OnInit, Input} from '@angular/core';
import {Hero} from '../todo/list/hero';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  @Input()
  heroInfo: Hero;
  constructor() {}

  ngOnInit() {
  }

}
