package com.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class CreateTaskPO extends BasePO{
    public CreateTaskPO(WebDriver driver) {
        super(driver);
    }

    @FindBy(how= How.ID, using="task_name")
    public WebElement name;

    @FindBy(how= How.CSS, using="[value='Create Task']")
    public WebElement submit;

    @FindBy(how= How.ID, using="task_bucket")
    public WebElement due;

    @FindBy(how= How.ID, using="task_category")
    public WebElement category;
}
