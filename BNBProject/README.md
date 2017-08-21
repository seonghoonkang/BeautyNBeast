# Bnbproject

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 1.2.4.
create angular project

1. npm install @angular/cli@1.X.X
2. npm install --save-dev angular-ide
3. ng new [Your Project Name] --directory ./ --skip-git

## Development server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.

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
