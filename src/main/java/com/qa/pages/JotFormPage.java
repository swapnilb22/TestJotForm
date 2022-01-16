package com.qa.pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.qa.base.TestBase;

public class JotFormPage extends TestBase 
{
	public JotFormPage()
	{
		PageFactory.initElements(driver, this);
	}

	

	@FindBy(id = "first_3")
	private WebElement firstName;

	@FindBy(id = "last_3")
	private WebElement lastName;

	@FindBy(id = "input_4_addr_line1")
	private WebElement line1_Address;

	@FindBy(id = "input_4_addr_line2")
	private WebElement line2_Address;

	@FindBy(id = "input_4_city")
	private WebElement city;

	@FindBy(id = "input_4_state")
	private WebElement state;

	@FindBy(id = "input_4_postal")
	private WebElement postalCode;

	@FindBy(id = "input_5_full")
	private WebElement phoneNumber;

	@FindBy(id = "input_6")
	private WebElement emailId;

	@FindBy(id = "input_8")
	private WebElement hearAboutUs;

	@FindBy(id = "input_9")
	private WebElement otherInput;

	@FindBy(id = "input_11")
	private WebElement feedbackToUs;

	@FindBy(id = "input_12")
	private WebElement suggestions;

	@FindBy(xpath = "//input[@type='checkbox'][1]")
	private WebElement recommendYes;

	@FindBy(id = "label_input_13_1")
	private WebElement recommendMayBe;

	@FindBy(id = "input_13_2")
	private WebElement recommendNo;

	@FindBy(id = "input_14_0_0")
	private WebElement refFNameOne;

	@FindBy(id = "input_14_0_1")
	private WebElement refAddressOne;

	@FindBy(id = "input_14_0_2")
	private WebElement refContactNoOne;

	@FindBy(id = "input_14_1_0")
	private WebElement refFNameTwo;

	@FindBy(id = "input_14_1_1")
	private WebElement refAddressTwo;

	@FindBy(id = "input_14_1_2")
	private WebElement refContactNoTwo;

	@FindBy(id = "input_2")
	private WebElement submitBtn;

	public void fillDetailsAndValidate(Map<Object, Object> map)
	{
		js = (JavascriptExecutor) driver;
		
		fillDetails(map);

		// Verify the data filled in the form
		//Assert.assertEquals(map.get("ConatctNo2").toString().trim(), refContactNoTwo.getAttribute("value").trim());

		SoftAssert soft_assert = new SoftAssert();

		soft_assert.assertEquals(firstName.getAttribute("value").trim(), map.get("FirstName").toString().trim());

		soft_assert.assertEquals(lastName.getAttribute("value").trim(), map.get("LastName").toString().trim());

		soft_assert.assertEquals(line1_Address.getAttribute("value").trim(), map.get("Line1Address").toString().trim());

		soft_assert.assertEquals(line2_Address.getAttribute("value").trim(), map.get("Line2Address").toString().trim());

		soft_assert.assertEquals(city.getAttribute("value").trim(), map.get("City").toString().trim());

		soft_assert.assertEquals(state.getAttribute("value").trim(), map.get("State").toString().trim());

		soft_assert.assertEquals(postalCode.getAttribute("value").trim(), map.get("Zip").toString().trim());

		String phNo = phoneNumber.getAttribute("value").trim();
		String number="";
		for(int i = 0; i< phNo.length(); i++)
		{
			char c = phNo.charAt(i);

			if(c=='('||c==')'||c=='-'||c==' ')
			{
				continue;
			}
			else 
			{
				number = number+c;
			}		
		}

		soft_assert.assertEquals(number, map.get("PhoneNo").toString().trim());

		soft_assert.assertEquals(emailId.getAttribute("value").trim(), map.get("Email").toString().trim());

		select = new Select(hearAboutUs);
		String optionSelected = select.getFirstSelectedOption().getText().trim();
		soft_assert.assertEquals(optionSelected, map.get("HearAboutUs").toString().trim());

		if(optionSelected.equals("Other (Please specify...)"))
		{
			soft_assert.assertEquals(otherInput.getAttribute("value").trim(), map.get("OtherInput").toString().trim());
		}

		soft_assert.assertEquals(feedbackToUs.getAttribute("value").trim(), map.get("Feedback").toString().trim());

		soft_assert.assertEquals(suggestions.getAttribute("value").trim(), map.get("Suggestion").toString().trim());

		soft_assert.assertEquals(refFNameOne.getAttribute("value").trim(), map.get("FullName1").toString().trim());

		soft_assert.assertEquals(refAddressOne.getAttribute("value").trim(), map.get("Address1").toString().trim());

		soft_assert.assertEquals(refContactNoOne.getAttribute("value").trim(), map.get("ConatctNo1").toString().trim());

		soft_assert.assertEquals(refFNameTwo.getAttribute("value").trim(), map.get("FullName2").toString().trim());

		soft_assert.assertEquals(refAddressTwo.getAttribute("value").trim(), map.get("Address2").toString().trim());

		//soft_assert.assertEquals(refContactNoTwo.getAttribute("value").trim(), map.get("ConatctNo2").toString().trim());

		boolean recommendYesSelected = false;
		if(recommendYes.isSelected())
		{
			recommendYesSelected = true;
		}
		soft_assert.assertTrue(recommendYesSelected);

		boolean recommendMayBe = false;
		if(recommendYes.isSelected())
		{
			recommendMayBe = true;
		}		
		soft_assert.assertTrue(recommendMayBe);


		boolean recommendNo = false;
		if(recommendYes.isSelected())
		{
			recommendNo = true;
		}
		soft_assert.assertTrue(recommendNo);

		soft_assert.assertAll();

		js.executeScript("arguments[0].click();", submitBtn);
	}


	public void fillDetails(Map<Object, Object> map)
	{
		//Fill the data in the form
		 js = (JavascriptExecutor) driver;

		firstName.sendKeys(map.get("FirstName").toString().trim());

		lastName.sendKeys(map.get("LastName").toString().trim());

		line1_Address.sendKeys(map.get("Line1Address").toString().trim());

		line2_Address.sendKeys(map.get("Line2Address").toString().trim());

		city.sendKeys(map.get("City").toString().trim());

		state.sendKeys(map.get("State").toString().trim());

		postalCode.sendKeys(map.get("Zip").toString().trim());

		phoneNumber.sendKeys(map.get("PhoneNo").toString().trim());

		emailId.sendKeys(map.get("Email").toString().trim());

		String option = map.get("HearAboutUs").toString().trim();
		select = new Select(hearAboutUs);

		select.selectByValue(option);
		if(option.equals("Other (Please specify...)"))
		{
			otherInput.sendKeys(map.get("OtherInput").toString().trim());	
		}

		feedbackToUs.sendKeys(map.get("Feedback").toString().trim());

		suggestions.sendKeys(map.get("Suggestion").toString().trim());

		js.executeScript("arguments[0].click();", recommendYes);

		js.executeScript("arguments[0].click();", recommendMayBe);

		js.executeScript("arguments[0].click();", recommendNo);

		refFNameOne.sendKeys(map.get("FullName1").toString().trim());

		refAddressOne.sendKeys(map.get("Address1").toString().trim());

		refContactNoOne.sendKeys(map.get("ConatctNo1").toString().trim());

		refFNameTwo.sendKeys(map.get("FullName2").toString().trim());

		refAddressTwo.sendKeys(map.get("Address2").toString().trim());

		refContactNoTwo.sendKeys(map.get("ContactNo2").toString().trim());
				
	}

	public String[] collectErrorMessage()
	{
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", submitBtn);

		List <WebElement> eMessages = driver.findElements(By.xpath("//div[@class='form-error-message'][contains(text(),'This field is required')]"));

		int noOfMessages = eMessages.size();

		String[] messages = new String[noOfMessages];

		for(int i = 0; i<noOfMessages; i++)
		{
			String errorMessage = eMessages.get(i).getText();

			messages[i] = errorMessage;
		}

		return messages;
	}
}

