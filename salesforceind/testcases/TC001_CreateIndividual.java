package com.salesforceind.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.testng.api.base.ProjectSpecificMethods;
import com.salesforceind.pages.SfLoginPage;

public class TC001_CreateIndividual extends ProjectSpecificMethods{
	@BeforeTest
	public void setValues() {
		testcaseName = "CreateIndividual";
		testDescription ="Create a new individual";
		authors="Ajay";
		category ="Smoke";
		excelFileName="Salesf";
	}
	
	@Test(dataProvider = "fetchData")
	public void runCreateIndividual(String username, String password, String lname, String fname){
		new SfLoginPage()
		.enterUsername(username)
		.enterPassword(password)
		.clickLogin()
		.verifySfHomePage()
		.clickWaIcon()
		.clickViewAllButton()
		.clickIndividual()
		.clickIndividualDrop()
		.clickNewIndividual()
		.enterLastName(lname)
		.clickSave()
		.verifyLastName(lname)
		.clickEdit()
		.selectSalutation()
		.enterFirstName(fname)
		.clickSaveButton()
		.verifyFirstName(fname);
		
	}

}
