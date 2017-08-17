import { Injectable } from '@angular/core';
import { Hero } from './hero';
import { HEROES } from './mock-data/mock-heroes';

@Injectable()
export class LoginService {
  constructor() { }
  getHeroes(): Promise<Hero[]> {
    return Promise.resolve(HEROES);
  }
}
