package com.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFName;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelConfig {
	XSSFWorkbook wb;
	XSSFSheet sheet1;
	
	public ExcelConfig(String xlpath){ //constructor
		
		
		try {
			File src=new File(xlpath);
			FileInputStream fis=new FileInputStream(src);
			wb=new XSSFWorkbook(fis);
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
		System.out.println("error on your code capi");
		}
		
	}
	
	
	public String getData(int sheetNumber,int row, int col){
		sheet1=wb.getSheetAt(sheetNumber);
		String myData=sheet1.getRow(row).getCell(col).getStringCellValue();
		return myData;
	}

	public int getRowCount(int SheetIndex){
		int row =wb.getSheetAt(SheetIndex).getLastRowNum();
		row=row+1;
		return row;
	}
	
	
		
	
	}

