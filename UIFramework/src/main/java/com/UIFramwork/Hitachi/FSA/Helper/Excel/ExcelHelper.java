package com.UIFramwork.Hitachi.FSA.Helper.Excel;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.UIFramwork.Hitachi.FSA.Helper.Resource.resourceHelper;
import com.UIFramwork.Hitachi.FSA.Helper.logger.LoggerHelper;

public class ExcelHelper {
	Logger log = LoggerHelper.getLogger(ExcelHelper.class);

	public Object[][] getExcelData(String ExcelLocation, String SheetName) {
		try {
			Object dataSet[][] = null;
			FileInputStream file = new FileInputStream(new File(ExcelLocation));

			// Create WorkBook Instance
			XSSFWorkbook Workbook = new XSSFWorkbook(file);

			// get Sheetname frome workbook
			XSSFSheet sheet = Workbook.getSheet(SheetName);

			// get active row
			int totalrow = sheet.getLastRowNum();

			// get active cell
			int totalcol = sheet.getRow(0).getLastCellNum();

			dataSet = new Object[totalrow+1][totalcol+1];
			// Iterate throw each row one by one
			 Iterator<Row> rowitrerator=sheet.iterator();
			 int i=0;
			 while(rowitrerator.hasNext()) {
				 i++;
				 Row row=rowitrerator.next();
				 Iterator<Cell> cellIterartor=row.cellIterator();
				 int j=0;
				 while(cellIterartor.hasNext()) {
					 j++;
					 Cell cell=cellIterartor.next();
					 switch(cell.getCellTypeEnum()) {
					 case STRING:
						 dataSet[i-1][j-1]=cell.getStringCellValue();
						 break;
					 case NUMERIC:	 
						 dataSet[i-1][j-1]=cell.getNumericCellValue();
						 break;
					 case BOOLEAN:
						 dataSet[i-1][j-1]=cell.getBooleanCellValue();
						 break;
					 case FORMULA:
						 dataSet[i-1][j-1]=cell.getCellFormula();
						 break;
						 default:
							 System.out.println("No enum data type found");
							 break;
					 }
					 
				 }
			 }
			 return dataSet;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/*public static void main(String[] args) {
	ExcelHelper helper=new ExcelHelper();
	String ExcelPath=resourceHelper.getResourcePath("/src/main/Resources/Configfile/TestData.xlsx");
	Object[][] data = helper.getExcelData(ExcelPath, "Login");
	//ArrayList<String> objects = new ArrayList<String>();
	List<Object[]>list= new ArrayList();
	//list.add(data);
	for (int i = 0; i < data.length; i++) {
		list.add(data[i]);
	}
	
	System.out.println(list.size());
for (int j = 0; j < list.size(); j++) {
	System.out.println(list.get(j));
	for (int k = 0; k <=j; k++) {
		System.out.println(list.indexOf(k));
	}
}
		
		
	}*/
	//System.out.println(data);
	}

