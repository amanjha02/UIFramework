package com.UIFramework;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CreateExcelFile {
	public static void main(String[] args) throws IOException {
		FileOutputStream fout=new FileOutputStream(new File("D:\\DataTest.xlsx"));
		XSSFWorkbook wb=new XSSFWorkbook();
		wb.write(fout);
		fout.close();
	}

}
