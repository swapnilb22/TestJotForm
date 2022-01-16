package com.qa.pages;

import org.testng.Assert;

import com.qa.base.TestBase;

public class ThankYouPage extends TestBase
{
	public void validatePageTitle()
	{
		String title = driver.getTitle();
		
		Assert.assertEquals(title, "Thank You");
	}

}
