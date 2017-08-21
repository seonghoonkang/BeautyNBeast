import { BnbprojectPage } from './app.po';

describe('bnbproject App', () => {
  let page: BnbprojectPage;

  beforeEach(() => {
    page = new BnbprojectPage();
  });

  it('should display welcome message', done => {
    page.navigateTo();
    page.getParagraphText()
      .then(msg => expect(msg).toEqual('Welcome to app!!'))
      .then(done, done.fail);
  });
});
