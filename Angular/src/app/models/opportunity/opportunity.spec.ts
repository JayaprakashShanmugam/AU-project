import { Opportunity } from './opportunity';

describe('Opportunity', () => {
  it('should create an instance', () => {
    expect(new Opportunity(0,"","","",0,0,"","","","")).toBeTruthy();
  });
});
