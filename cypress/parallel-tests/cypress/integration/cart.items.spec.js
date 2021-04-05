import {LOGIN_USERS, PAGES} from '../support/e2eConstants';
import AppHeaderPage from '../page-objects/AppHeaderPage';
import SwagOverviewPage from '../page-objects/SwagOverviewPage';

describe('Swag Item Details', () => {

  it('should validate that a product can be added to a cart', () => {
    cy.setTestContext({
      user: LOGIN_USERS.STANDARD,
      path: PAGES.SWAG_ITEMS,
    });

    AppHeaderPage.cart.should('have.text', '');
    SwagOverviewPage.addSwagToCart(0);
    AppHeaderPage.cart.should('have.text', '1');
  });

  it('should validate that a product can be removed from the cart', () => {
    cy.setTestContext({
      user: LOGIN_USERS.STANDARD,
      path: PAGES.SWAG_ITEMS,
    });

    // Actual test starts here
    AppHeaderPage.cart.should('have.text', '');
    SwagOverviewPage.removeSwagFromCart(0);
    AppHeaderPage.cart.should('have.text', '');
  });
});
