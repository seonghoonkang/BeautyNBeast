import {Injectable} from '@angular/core';
import {HEROES} from '../../mock-data/mock-heroes';
import {TodoVO} from './todo.vo';
import {Http} from '@angular/http';
import 'rxjs/add/operator/toPromise';

@Injectable()
export class TodoService {
  constructor(private http: Http) {}
  getTodoList(): Promise<TodoVO[]> {
    //        const list: Promise<TodoVO[]> = Promise.resolve(HEROES);
     const list: Promise<TodoVO[]> = this.http.get('app/todoList').toPromise()
      .then(response => {
        const res: TodoVO[] = (response.json().data as TodoVO[]);
        console.log(res);
        return response.json().data as TodoVO[];
      });
    return list;
  }
  getTodo(id: number): Promise<TodoVO> {
    return this.getTodoList().then(todoList => todoList.find(elm => elm.id === id));
  }
  getFavoKeywords(): void {
    this.http.get('http://123.212.190.194:7614/ksf/api/rankings?domain_no=0')
      .toPromise()
      .then(response => console.log(response));
  }

  handleError(error: string): Promise<string> {
    console.error('An error occurred', error);
    return Promise.reject(error);
  }
}
