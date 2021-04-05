import SwagOverviewPage from '../page-objects/SwagOverviewPage';
import CartSummaryPage from "../page-objects/CartSummaryPage";
import MenuPage from "../page-objects/MenuPage";
import {LOGIN_USERS, PAGES} from "../support/e2eConstants";

describe('Menu', () => {
  beforeEach(() => {
    cy.setTestContext({
      user: LOGIN_USERS.STANDARD,
      path: PAGES.CART,
    });
    CartSummaryPage.screen.should('be.visible');
    MenuPage.open();
  });

  it('should be able to the swag items overview page', () => {
    MenuPage.openInventoryList();
    SwagOverviewPage.screen.should('be.visible');
  });
})
