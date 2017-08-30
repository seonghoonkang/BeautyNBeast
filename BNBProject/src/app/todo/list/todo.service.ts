import {Injectable} from '@angular/core';
import {HEROES} from '../../mock-data/mock-heroes';
import {TodoVO} from './todo';

@Injectable()
export class TodoService {
    constructor() {}
    getTodoList(): Promise<TodoVO[]> {
        const list: Promise<TodoVO[]> = Promise.resolve(HEROES);
        return list;
    }
    getTodo(id: number): Promise<TodoVO> {
        return this.getTodoList().then(todoList => todoList.find(elm => elm.id === id));
    }
}
