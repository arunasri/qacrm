package com.tests;

import com.po.CreateTaskPO;
import com.po.DashBoardPO;
import com.po.LoginPO;
import com.po.TaskPO;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TaskTest extends BaseTest{
    @BeforeMethod(alwaysRun = true)
    public void loginUser(){
        //Given logged in user
        LoginPO loginPO = new LoginPO(driver);
        loginPO.login("george", "george");

        //And on tasks page
        DashBoardPO dashBoardPO = new DashBoardPO(driver);
        dashBoardPO.tasksLink.click();
    }


    @Test
    public void createTask(){
        logger.info("going to tasks page");
        //When click on create task link
        TaskPO taskPO = new TaskPO(driver);
        taskPO.createTaskLink.click();
        //And wait until create task form opens
        WebDriverWait createTaskFormWait = new WebDriverWait(driver, 3);
        createTaskFormWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("task_category")));

        //Then complete create task form
        CreateTaskPO createTaskPO = new CreateTaskPO(driver);
        createTaskPO.name.sendKeys("foo task");

        createTaskPO.categorySelect().selectByVisibleText("Lunch");
        createTaskPO.dueSelect().selectByVisibleText("Tomorrow");

        Actions action = new Actions(driver);
        action.moveToElement(createTaskPO.assignTo);
        action.click();
        action.sendKeys("Cindy Cluster");
        action.build().perform();

        driver.findElement(By.className("select2-results__option--highlighted")).click();


        createTaskPO.submit.click();
    }
}
