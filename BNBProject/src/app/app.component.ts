import {Component, OnInit, OnChanges, SimpleChanges} from '@angular/core';
import {Hero} from './hero';
import {LoginService} from './login.service';
@Component({
  selector: 'app-bnb',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit, OnChanges {
  title = '할일 도움이를 찾아 주셔서 반갑습니다.';
  heroes: Hero[];
  selectedHero: Hero;
  constructor(private loginService: LoginService) {
    //    this.heroes = loginService.getHeroes(); --> avoid
  };

  //  Angular 에서는 new 연산자를 사용하지 않도록 권장:
  //  Why?
  //  1.서비스에 파라미터를 받도록 수정한다면 모든 생성자를 수정해야한다.
  //  2.수 만은 객채가 발생한다.

  onSelect(hero: Hero): void {
    this.selectedHero = hero;
  }

  ngOnInit(): void {
    console.log('ngOnInit');
    this.heroes = this.loginService.getHeroes();
  }

  ngOnChanges(changes: SimpleChanges): void {
    console.log('ngOnChanges');
  }

}
