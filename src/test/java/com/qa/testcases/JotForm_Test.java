package com.qa.testcases;

import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.JotFormPage;
import com.qa.pages.ThankYouPage;
import com.qa.util.ExcelReader;
import com.qa.util.ExcelWriter;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.util.Map;

import org.testng.annotations.AfterMethod;

public class JotForm_Test extends TestBase 
{
	JotFormPage jotFormPage;
	ThankYouPage thankYouPage;

//DataProver: This will get the data from the Excel Sheet
	@DataProvider
	public Object[][] getCustomerData() throws IOException
	{
		Object data[][] = ExcelReader.dataSupplier();
		return data;
	}

//This test case verify the data enter from the Excel is correct or not
	@Test(dataProvider="getCustomerData", enabled=true)
	public void verifyDetails(Map<Object, Object> map) 
	{
		jotFormPage = new JotFormPage();
		jotFormPage.fillDetailsAndValidate(map);
	}
	
//This test case will collect all the error messages	
	@Test(dataProvider="getCustomerData", enabled=true)
	public void verifyJotForm(Map<Object, Object> map) 
	{
		jotFormPage = new JotFormPage();
		jotFormPage.fillDetailsAndValidate(map);
		
		thankYouPage = new ThankYouPage();
		thankYouPage.validatePageTitle();
	}



	@Test(enabled=true)
	public void getErrorMessages()
	{
		jotFormPage = new JotFormPage();

		try {
			ExcelWriter.WriteExcel(jotFormPage.collectErrorMessage());
		} 
		catch (Exception e) 
		{

			e.printStackTrace();
		}

	}

	@BeforeMethod
	public void beforeMethod() 
	{
		initialization();
	}

	@AfterMethod
	public void afterMethod() 
	{
	}
}