package com.tests;

import com.po.HomePO;
import com.po.LoginPO;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTest extends BaseTest{

    @Test
    public void validLogin() {
        SoftAssert verify = new SoftAssert();

        LoginPO loginPO = new LoginPO(this.driver);
        loginPO.login("heather", "heather");

        HomePO homePO = new HomePO(this.driver);
        //check welcome_user span is not null,
        //if null means user is not logged in
        //we want to use assert here
        Assert.assertNotNull(homePO.welcomeUser);

        //we checked welcomeUser which is valid so now we want check the value
        //if this is wrong we don't want the tests stop
        verify.assertEquals("Heather", homePO.welcomeUser.getText());
        verify.assertNotNull(homePO.logoutLink);
        verify.assertNotNull(homePO.adminLink);
        verify.assertNotNull(homePO.profileLink);


        verify.assertAll();
    }

    @Test
    public void checkAllElementsOnLoginPage() {
        SoftAssert verify = new SoftAssert();

        LoginPO loginPO = new LoginPO(this.driver);

        verify.assertNotNull(loginPO.username);
        verify.assertNotNull(loginPO.password);
        verify.assertNotNull(loginPO.submit);
        verify.assertNotNull(loginPO.rememberMeRadioButton);
        verify.assertNotNull(loginPO.forgotPasswordLink);
        verify.assertNotNull(loginPO.aboutLink);
        verify.assertNotNull(loginPO.loginLink);
        //check warning is empty
        verify.assertEquals("", loginPO.warning.getText());

        verify.assertAll();
    }

    @Test
    public void invalidLogin() {
        SoftAssert verify = new SoftAssert();

        LoginPO loginPO = new LoginPO(this.driver);
        loginPO.login("heather", "wrong");

        Assert.assertNotNull(loginPO.warning);

        verify.assertEquals("Invalid username or password.", loginPO.warning.getText());

        verify.assertAll();
    }


    @Test(dataProvider = "users")
    public void testMultiUserLogin(String username, String password) {
        LoginPO loginPO = new LoginPO(this.driver);
        loginPO.login(username, password);

        HomePO homePO = new HomePO(this.driver);
        //check welcome_user span is not null,
        //if null means user is not logged in
        //we want to use assert here
        Assert.assertNotNull(homePO.welcomeUser);
    }

    @DataProvider(name = "users")
    public static Object[][] credentials() {
        return new Object[][] {
                { "heather", "heather" },
                { "george", "george" },
                { "frank", "frank" },
                { "elizabeth", "elizabeth" },
                { "cindy", "cindy" },
                { "ben", "ben" },
                { "aaron", "aaron" },
                { "dan", "dan" }
        };
    }
}
