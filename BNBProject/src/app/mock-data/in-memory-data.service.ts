import {TodoVO} from '../todo/list/todo.vo';
export class InMemoryDataService implements InMemoryDataService {
    createDb() {
        let todoList = [
            new TodoVO(11, 'Mr. Nice'),
            new TodoVO(12, 'Narco'),
            new TodoVO(13, 'Bombasto'),
            new TodoVO(14, 'Celeritas'),
            new TodoVO(15, 'Magneta'),
            new TodoVO(16, 'RubberMan'),
            new TodoVO(17, 'Dynama'),
            new TodoVO(18, 'Dr IQ'),
            new TodoVO(19, 'Magma'),
            new TodoVO(10, 'Tornado'),
        ];
        return {todoList};
    }
}
