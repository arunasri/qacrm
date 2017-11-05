package com.tests;

import com.po.ForgoPasswordPO;
import com.po.LoginPO;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ForgotPasswordTest extends BaseTest{
    @Test
    public void checkForgotPassword(){
        LoginPO loginPO = new LoginPO(this.driver);
        loginPO.forgotPasswordLink.click();

        ForgoPasswordPO forgoPasswordPO = new ForgoPasswordPO(this.driver);
        SoftAssert verify = new SoftAssert();

        verify.assertNotNull(forgoPasswordPO.email);
        verify.assertNotNull(forgoPasswordPO.resetPasswordButton);
        verify.assertNotNull(forgoPasswordPO.intro);
        verify.assertNotNull(forgoPasswordPO.title);

        verify.assertEquals("Forgot Password", forgoPasswordPO.title.getText());
        verify.assertEquals(forgoPasswordPO.INTRO_TEXT, forgoPasswordPO.intro.getText());

        verify.assertAll();
    }
}
