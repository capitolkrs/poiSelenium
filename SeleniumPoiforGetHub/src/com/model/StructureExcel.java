package com.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class StructureExcel {
	XSSFWorkbook myWb;
	public StructureExcel(String mypath) {
		File mySrc = new File(mypath);
		FileInputStream myFis;
		

		try {
			myFis = new FileInputStream(mySrc);
			myWb = new XSSFWorkbook(myFis);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
		public int myRowcnt(int shIndex){
			int myLastRow=myWb.getSheetAt(shIndex).getLastRowNum();
			myLastRow=myLastRow+1;
			return myLastRow;
		
		}
		public String fetchData(int SheetLocation,int myRow,int myCol){
			XSSFSheet mySh=myWb.getSheetAt(SheetLocation);
			String rowContent=mySh.getRow(myRow).getCell(myCol).getStringCellValue();
			return rowContent;
			
		}
	}


