package addToCartTest;

import baseTest.BaseTest;
import libs.TestData;
import org.junit.After;
import org.junit.Test;
import pages.AccountPage;

public class AddToCartTest extends BaseTest {
    private Integer amount = 0;

    @Test
    public void addToCart() {
        loginPage.openLoginPage();
        loginPage.enterEmailInInput(TestData.VALID_LOGIN);
        loginPage.enterPasswordInInput(TestData.VALID_PASSWORD);
        loginPage.clickOnButtonSignIn();
        loginPage.checkActualAmountOfOrders();
        loginPage.enterBookName(TestData.BOOK_NAME);
        loginPage.clickOnButtonSearch();
        loginPage.clickOnButtonAddToCart();
        loginPage.closePopup();
        loginPage.clickOnCartButton();
        loginPage.checkIsBookWasAddedToCart();
    }

//    Надо написать послеусловия на удаление всех книг в корзине
    // Пока решил предварительной записью содержимого корзины в переменную
//    @After
//    public void deleteOrders(){
//        accountPage.openAccountPage()
//        .checkIsButtonSignOutVisible();
//        loginPage.clickOnCartButton();
////        accountPage.deleteOrdersWhilePresent();
//    }
}
