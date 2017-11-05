package com.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TaskPO extends BasePO{
    public TaskPO(WebDriver driver) {
        super(driver);
    }


    @FindBy(how= How.PARTIAL_LINK_TEXT, using="Create Task")
    public WebElement createTaskLink;



}
