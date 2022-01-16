package com.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader 
{

	public static Object[][] dataSupplier() throws IOException {

		File file = new File("C:\\Users\\swapnil.bhaskar\\eclipse-workspace\\Test_EverythingFInancial\\src\\main\\java\\com\\qa\\testdata\\TestData.xlsx");
		FileInputStream fis = new FileInputStream(file);

		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		// wb.close();
		int lastRowNum = sheet.getLastRowNum() ;
		int lastCellNum = sheet.getRow(0).getLastCellNum();
		Object[][] obj = new Object[lastRowNum][1];
		try
		{
			for (int i = 0; i < lastRowNum; i++) 
			{
				Map<Object, Object> datamap = new HashMap<Object, Object>();
				for (int j = 0; j < lastCellNum; j++) 
				{
//					if(sheet.getRow(i+1).getCell(j).toString()==null)
//					{
//						datamap.put(sheet.getRow(0).getCell(j).toString(), "NA");
//					}
//
//					else{
//							datamap.put(sheet.getRow(0).getCell(j).toString(), sheet.getRow(i+1).getCell(j).toString());
//						}
					
					datamap.put(sheet.getRow(0).getCell(j).toString(), sheet.getRow(i+1).getCell(j).toString());
				}
				obj[i][0] = datamap;

			}
		}catch(NullPointerException e)
		{
			System.out.println("Null cell found");
		}
		return  obj;
	}


}