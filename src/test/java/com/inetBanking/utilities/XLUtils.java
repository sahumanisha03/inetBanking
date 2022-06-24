package com.inetBanking.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {
	
	public static FileInputStream fileinput;
	public static FileOutputStream fileoutput;
	public static XSSFWorkbook wb;
	public static XSSFSheet fs;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static int getRowCount(String xlfile, String xlsheet) throws IOException 
	{
		fileinput =new FileInputStream(xlfile);
		wb= new XSSFWorkbook(fileinput);
		fs= wb.getSheet(xlsheet);
		int rowcount= fs.getLastRowNum();
		wb.close();
	    fileinput.close();
		return rowcount;
		
	}
	
	public static int getCellCount(String xlfile, String xlsheet, int rownum) throws IOException
	{
		fileinput= new FileInputStream(xlfile);
		wb= new XSSFWorkbook(fileinput);
		fs= wb.getSheet(xlsheet);
		row= fs.getRow(rownum);
		int cellcount= row.getLastCellNum();
		wb.close();
	    fileinput.close();
		return cellcount;
		
	}
	
	public static String getCellData(String xlfile, String xlsheet, int rownum, int column) throws IOException
	{
		fileinput= new FileInputStream(xlfile);
		wb= new XSSFWorkbook(fileinput);
		fs= wb.getSheet(xlsheet);
		row= fs.getRow(rownum);
		cell= row.getCell(column);
		String data;
		try {
			DataFormatter format= new DataFormatter();
			String cellData= format.formatCellValue(cell);
			return cellData;
		}
		catch(Exception e) {
			data="";
		}
		wb.close();
		fileinput.close();
		;
		return data;
	}
	
	public static void setCellData(String xlfile, String xlsheet, int rownum, int column, String data) throws IOException 
	{
		fileinput= new FileInputStream(xlfile);
		wb= new XSSFWorkbook(fileinput);
		fs= wb.getSheet(xlsheet);
		row= fs.getRow(rownum);
		cell= row.createCell(column);
		cell.setCellValue(data);
		fileoutput=new FileOutputStream(xlfile);
		wb.write(fileoutput);
		wb.close();
		fileinput.close();
		fileoutput.close();
	}
	
	
}
