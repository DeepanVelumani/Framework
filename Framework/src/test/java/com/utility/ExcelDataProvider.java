package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	public XSSFWorkbook wb;
	
	public ExcelDataProvider()
	{
		File src=new File("C:\\Users\\91978\\Selenium WorkSpace\\Framework\\TestData\\TestData.xlsx");
		try
		{
			FileInputStream fis = new FileInputStream(src);
			
			 wb = new XSSFWorkbook(fis);
		} 
		catch (Exception e) {
			
			System.out.println("The Excel file is not available "+e.getMessage());
		}
	}

	
	public String getStringData(String sheetName,int row,int column)
	{
		return wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
		
	}
	
	public String getStringData(int sheetIndex,int row,int column)
	{
		return wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
		
	}
	
	public double getNumericData(String sheetName,int row,int column)
	{
		return wb.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
		
	}
	
	
}
