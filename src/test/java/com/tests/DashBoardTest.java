package com.tests;

import com.po.DashBoardPO;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DashBoardTest extends BaseTest{

    @Test
    public void adminDashboard() {
        //Given admin user logged in
        logger.info("Given when logged in as admin");
        //Check BaseTest for this method
        loginAsAdmin();

        //When on dashboard
        logger.info("When user is on home page");
        DashBoardPO dashboardPO = new DashBoardPO(this.driver);

        //Then It should have tabs
        logger.info("Then i should see tabs");
        SoftAssert verifies = new SoftAssert();
        verifies.assertNotNull(dashboardPO.dashboardLink);
        verifies.assertNotNull(dashboardPO.tasksLink);
        verifies.assertNotNull(dashboardPO.campaignsLink);
        verifies.assertNotNull(dashboardPO.leadsLink);
        verifies.assertNotNull(dashboardPO.accountsLink);
        verifies.assertNotNull(dashboardPO.contactsLink);
        verifies.assertNotNull(dashboardPO.opportunityLink);
        verifies.assertNotNull(dashboardPO.teamLink);

        logger.info("We need to see admin link");
        verifies.assertTrue(isElementPresent(dashboardPO.adminLink), "admin link should be blank");

        verifies.assertAll();
    }

    @Test
    public void nonAdminDashBoard() {
        //Given admin user logged in
        logger.info("Given when logged in as reggular user");
        loginAsNonAdmin();

        //When on dashboard
        logger.info("When user is on home page");
        DashBoardPO dashboardPO = new DashBoardPO(this.driver);

        //Then It should have tabs
        logger.info("Then i should see tabs");
        SoftAssert verifies = new SoftAssert();
        verifies.assertNotNull(dashboardPO.dashboardLink, "non admin should have dashboard link");
        verifies.assertNotNull(dashboardPO.tasksLink, "non admin should have task link");
        verifies.assertNotNull(dashboardPO.campaignsLink, "non admin should have campaign link");
        verifies.assertNotNull(dashboardPO.leadsLink, "non admin should have leaders link");
        verifies.assertNotNull(dashboardPO.accountsLink, "non admin should have accounts link");
        verifies.assertNotNull(dashboardPO.contactsLink, "non admin should have contacts link");
        verifies.assertNotNull(dashboardPO.opportunityLink, "non admin should have opportunity link");
        verifies.assertNotNull(dashboardPO.teamLink, "non admin user should have team link");

        logger.info("We should not see admin link");
        verifies.assertFalse(isElementPresent(dashboardPO.adminLink), "admin link should be blank");

        verifies.assertAll();
    }

}
