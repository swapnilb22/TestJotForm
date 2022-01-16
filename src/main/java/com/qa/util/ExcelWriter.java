package com.qa.util;

import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelWriter
{
	
public static void WriteExcel(String[] dataToWrite)
{
	String filePath = "C:\\Users\\swapnil.bhaskar\\eclipse-workspace\\Test_EverythingFInancial\\src\\main\\java\\com\\qa\\testdata\\InsertTestData.xlsx";
	
	try
	  {
		Workbook wb=new XSSFWorkbook();
		
        Sheet sheet1 = wb.createSheet("ErrorMessage");
        
	    for(int j = 0; j < dataToWrite.length; j++)
	    {
	    	 Row rowhead = sheet1.createRow(j);
	    	
	    	 rowhead.createCell(0).setCellValue(dataToWrite[j]);
	    }
	  	    		
	    FileOutputStream fileOut = new FileOutputStream(filePath);
	    
	    wb.write(fileOut);
	    
	    fileOut.close();
	    
	    System.out.println("Excel file has been generated successfully.");
	  }
	  catch (Exception e)
	  {
	    e.printStackTrace();
	  }
	}}
