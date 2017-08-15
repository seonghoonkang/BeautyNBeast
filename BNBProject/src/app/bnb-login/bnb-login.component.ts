import {Component, OnInit, Input} from '@angular/core';
import {Hero} from '../hero';
@Component({
  selector: 'app-bnb-login',
  templateUrl: './bnb-login.component.html',
  styleUrls: ['./bnb-login.component.css']
})
export class BnbLoginComponent implements OnInit {
  @Input()
  heroInfo: Hero;
  constructor() {}

  ngOnInit() {
  }

}
