import { BNBProjectPage } from './app.po';

describe('bnbproject App', () => {
  let page: BNBProjectPage;

  beforeEach(() => {
    page = new BNBProjectPage();
  });

  it('should display welcome message', done => {
    page.navigateTo();
    page.getParagraphText()
      .then(msg => expect(msg).toEqual('Welcome to app!!'))
      .then(done, done.fail);
  });
});
