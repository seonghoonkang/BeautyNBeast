# Bnbproject

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 1.2.4.
create angular project

1. npm install @angular/cli@1.X.X
2. npm install --save-dev angular-ide
3. ng new [Your Project Name] --directory ./ --skip-git

## Development server

1. Project facets JDK 1.8
2. Add maven-library to Properties > Deployment Assembly
3. if you get error like that Failed to start component - ZipException: invalid LOC header (bad signature), 
then clean your maven repository (C:\users\[your]\.m2\repository)  
4. BNBCommon 에 Apache library 제거

## Code scaffolding

Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive|pipe|service|class|module`.

## Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory. Use the `-prod` flag for a production build.
if arise 'ERROR in ./src/main.ts Module not found: Error: Can't resolve' then
    Your angular-cli is version 1.1.0 and zone.js@0.8.4
    Updating to @angular/cli@1.2.4 and zone.js@0.8.14
    Then
    remove node_modules directory
    npm cache clear
    npm install
    fixed the issue with ng build --prod

## Running unit tests

Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

## Running end-to-end tests

Run `ng e2e` to execute the end-to-end tests via [Protractor](http://www.protractortest.org/).
Before running the tests make sure you are serving the app via `ng serve`.

## Further help

To get more help on the Angular CLI use `ng help` or go check out the [Angular CLI README](https://github.com/angular/angular-cli/blob/master/README.md).

## Create DB
mysqladmin -u root -p password new-password; //root 암호 설정 
mysql -u root mysql;// root 계정으로 클라이언트 접속
use mysql; // mysql DB로 접속

set password for root = password('new-password');//root 암호 설정
update user set password = password('new-password') where user = 'root'; //root 암호설정

show Databases; // 데이터베이스 보기- root계정은 외부 접근 불가 </br>
create database todo; // 데이터베이스 생성 </br>

select host, user, password from user; // 사용자 정보 조회
create user [userid];// 사용자 생성
create user '[userid]'@'[access-host]' identified by '[password]'; //access-host는 %, localhost, ip등이 올 수 있다.
insert into user(host, user, password) value ('[access-host]', '[userid]', '[password]');

show grants for [userid]@[host]; //권한확인하기
grant all privileges on [dbname].* to [userid]@[host] identified by [password]; //권한 설정 dbname.* 대신 dbname.table, dbname.view등 지정할 수 있다.
flush privileges; //권한 적용

