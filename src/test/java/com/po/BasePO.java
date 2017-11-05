package com.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePO {
    private WebDriver driver;


    BasePO(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }


    public final void  enterText(WebElement element, String input) {
        element.clear();
        element.sendKeys(input);
    }
}
