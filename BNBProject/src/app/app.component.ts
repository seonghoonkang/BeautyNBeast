import {Component, OnInit, OnChanges, SimpleChanges} from '@angular/core';
@Component({
  selector: 'app-bnb',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit, OnChanges {
  title = '할일 도움이를 찾아 주셔서 반갑습니다.';

  constructor() {
    //    this.heroes = loginService.getHeroes(); --> avoid
  };



  ngOnInit(): void {
  }

  ngOnChanges(changes: SimpleChanges): void {
    console.log('ngOnChanges');
  }

}
