describe('A basic test', () => {

  beforeEach(() => {
    cy.visit('');
  });

  it('should be able to test loading of login page', () => {
    cy.title().should('include', 'Swag')
  });

});
