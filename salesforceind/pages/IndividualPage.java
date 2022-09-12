package com.salesforceind.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;
import com.salesforce.pages.ChatterPage;

public class IndividualPage extends ProjectSpecificMethods {

	public IndividualPage clickIndividualDrop() {
		click(locateElement(Locators.XPATH,
				"//div[@class='slds-context-bar__label-action slds-p-left--none slds-p-right--x-small']/one-app-nav-bar-menu-button"));
		reportStep("Individual dropdown is clicked successfully", "pass");
		return this;
	}

	public IndividualPage clickNewIndividual() {
		clickUsingJs(locateElement(Locators.XPATH, "(//span[text()='New Individual'])"));
		reportStep("New Individual is clicked successfully", "pass");
		return this;
	}

	public IndividualPage enterLastName(String data) {

		clearAndType(locateElement(Locators.XPATH, "//input[@placeholder='Last Name']"), data);

		reportStep("Lastname is entered successfully", "pass");
		return this;
	}

	public IndividualPage clickSave() {
		click(locateElement(Locators.XPATH, "//button[@title='Save']//span[1]"));
		reportStep("Save button is clicked successfully", "pass");
		return this;
	}

	public IndividualPage verifyLastName(String data) {
		verifyExactText(locateElement(Locators.XPATH, "(//span[@class='uiOutputText'])[1]"), data);
		reportStep(data + " is matching with provided Last name", "pass");
		return this;

	}

	public IndividualPage clickEdit() {
		click(locateElement(Locators.XPATH, "//div[@title='Edit']"));
		reportStep("Edit button is clicked successfully", "pass");
		return this;
	}

	public IndividualPage selectSalutation() {
		click(locateElement(Locators.XPATH, "//a[@class='select']"));
		click(locateElement(Locators.XPATH, "//a[text()='Mr.']"));
		reportStep("Salutation is selected successfully", "pass");
		return this;
	}

	public IndividualPage enterFirstName(String data) {

		clearAndType(locateElement(Locators.XPATH, "//input[@placeholder='First Name']"), data);
		reportStep("First name is entered successfully", "pass");
		return this;
	}

	public IndividualPage clickSaveButton() {
		click(locateElement(Locators.XPATH, "//button[@title='Save']"));
		reportStep("Save button is clicked successfully", "pass");
		return this;
	}

	public IndividualPage verifyFirstName(String data) {
		pause(500);
		WebElement ele = locateElement(Locators.XPATH, "//span[contains(text(),'" + data + "')]");
		verifyPartialText(ele, data);
		reportStep("First name:" +data + " is present in the Individual name", "pass");
		return this;

	}

}
