package com.UIFramework;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReading {
	static int totalcol =0;
	@SuppressWarnings("null")
	public Object[][] getExcelData() {
		try {
			Object[][] data = null;
			FileInputStream fis = new FileInputStream(new File("C:\\Users\\ajha\\Desktop\\TestData.xlsx"));
			// create an object of workbook
			XSSFWorkbook workbook = new XSSFWorkbook(fis);

			// create an object of sheet
			XSSFSheet sheet = workbook.getSheetAt(0);
			int totalrow = sheet.getLastRowNum();
			 totalcol = sheet.getRow(0).getLastCellNum();
			data = new Object[totalrow+1][totalcol];

			Iterator<Row> rowiterator = sheet.iterator();
			int i=0;
			while (rowiterator.hasNext()) {
				i++;
				// for every row we need to iterate over coloum;
				Row row = rowiterator.next();
				Iterator<Cell> celliterator = row.cellIterator();
				int j=0;
				while (celliterator.hasNext()) {
					j++;
					Cell cell = celliterator.next();
					switch (cell.getCellTypeEnum()) {
					case STRING:
						data[i-1][j-1] = cell.getStringCellValue();
						break;
					case NUMERIC:
						data[i-1][j-1] = cell.getNumericCellValue();
						break;
					case BOOLEAN:
						data[i-1][j-1] = cell.getBooleanCellValue();
						break;
					case FORMULA:
						data[i-1][j-1] = cell.getCellFormula();
						break;
					default:
						System.out.println("No matching enum data type found");
						break;
					}
					
				}
				
			}
			return data;
//		Iterator<Row>rowiterator=sheet.iterator();
//		while(rowiterator.hasNext()) {
//		//for every row we need to iterate over coloum;
//			Row row =	rowiterator.next();
//			Iterator<Cell> celliterator= row.cellIterator();
//			while(celliterator.hasNext()) {
//				System.out.print(celliterator.next().getStringCellValue()+" ||");
//			}
//			
//			System.out.println();
//		}

//			    System.out.println("column number is :"+ totalcol + ":total row is :"+totalrow );
//			    
//			    for (int i = 0; i < totalrow; i++) {
//			    	for (int j = 0; j < totalcol; j++) {
//			    		String cellvalue = sheet.getRow(i).getCell(j).getStringCellValue();
//						System.out.print(cellvalue+" ||");
//					}
//					System.out.println();
//				}

		} catch (Exception e) {
			e.printStackTrace();
			
		}
	return null;	

	}

	public static void main(String[] args) {
		ExcelReading ex = new ExcelReading();
		Object[][] dataset=ex.getExcelData();
		int length1=dataset.length;
		for (int i = 0; i < dataset.length; i++) {
			for (int j = 0; j < totalcol; j++) {
				System.out.print(dataset[i][j]+"||");
				
			}
			System.out.println();
		}
		System.out.println(length1);
		//System.out.println(ex.getExcelData());
	}

}
