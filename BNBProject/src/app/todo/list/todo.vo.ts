export class TodoVO {
    id: number;
    name: string;
    constructor(public argid: number, public argname: string) {
        this.id = argid;
        this.name = argname;
    }
}
