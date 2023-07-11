package org.NewaInsurance_GenrericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This Class consists of excel read or write the data into excel libraries how to get data from excel and how to write the data into excel
 * 
 * @author prasanna
 *
 */

/**
 * @author prasanna
 *
 */
public class ExcelUtilities {

	

	/**
	 * This method is used to get the data from the excel using the parameters like
	 * ExcelUpath, sheet ,rownum and cellnum
	 * 
	 * @param ExcelUtpath
	 * @param rownum
	 * @param cellnum
	 * @return data
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String getDatafromExcel(String sheet, int rownum, int cellnum) {

		String data = null;
		try {
			FileInputStream fis = new FileInputStream(IconstantUtitlity.excelpath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheet);
			Row row = sh.getRow(rownum);
			data = row.getCell(cellnum).toString();
			wb.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	/**
	 * This method is used to get the row count using the ExcelUpath and sheet
	 * 
	 * @param ExcelUpath
	 * @param sheet
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public int getrowCount(String ExcelUpath, String sheet) {

		int rowCount = 0;

		try {
			FileInputStream fis = new FileInputStream(ExcelUpath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheet);
			rowCount = sh.getLastRowNum();

		} catch (EncryptedDocumentException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return rowCount;

	}

	/**
	 * This method is used to Set the data into excel by using the parameters such
	 * as ExcelUpath, sheet rownum,cellnum, data
	 * 
	 * @param ExcelUpath
	 * @param sheet
	 * @param rownum
	 * @param cellnum
	 * @param data
	 * @return 
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String setDatainExcel( String sheet, int rownum, int cellnum, String data) {
		FileInputStream fis;
		Workbook wb;
		try {
			fis = new FileInputStream(IconstantUtitlity.excelpath);
			wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet(sheet);
			Row row = sh.getRow(rownum);
			Cell cell = row.createCell(cellnum);
			cell.setCellValue(data);
			FileOutputStream fos = new FileOutputStream(IconstantUtitlity.excelpath);
			wb.write(fos);
			wb.close();
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		} catch (EncryptedDocumentException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
	
			e.printStackTrace();
		}
		return data;

	}

	/***
	 * This method is used to fetch the data from the database based on the
	 * following parameters and return String data
	 * 
	 * @param ExcelUpath
	 * @param sheet
	 * @param testId
	 * @param columnheader
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */

	public String getDatabasedOnTestId( String sheet, String testId, String columnheader)
			throws EncryptedDocumentException, IOException {

		FileInputStream fis = new FileInputStream(IconstantUtitlity.excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("TestData");
		int rowcount = sh.getLastRowNum();
		int testrownum = 0;
		String actualTestId = "";
		String actualcolumnheadr = "";
		String data = "";

		for (int i = 0; i <= rowcount; i++) {
			try {
				actualTestId = sh.getRow(i).getCell(0).toString();
			} catch (Exception e) {
			}

			if (actualTestId.equalsIgnoreCase(testId)) {
				break;
			}
			testrownum++;
		}
		int testColNum = 0;
		int celCountforTest = sh.getRow(testrownum - 1).getLastCellNum();
		for (int j = 0; j < celCountforTest; j++) {
			try {
				actualcolumnheadr = sh.getRow(testrownum - 1).getCell(j).toString();
			} catch (Exception e) {
			}
			if (actualcolumnheadr.equalsIgnoreCase(columnheader)) {
				break;
			}
			testColNum++;
		}
		try {
			data = sh.getRow(testrownum).getCell(testColNum).toString();
		} catch (Exception e) {
		}
		return data;
	}
	
	
	public Object[][] getMutlipleDatafromExcel(String sheet) throws EncryptedDocumentException, IOException{
		FileInputStream fis= new FileInputStream(IconstantUtitlity.excelpath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheet);
		int lastrow=sh.getLastRowNum();
		int lastcell=sh.getRow(0).getLastCellNum();
		Object[][] data =new Object[lastrow][lastcell];
		for(int i=0;i<lastrow;i++) {
			for(int j=0;j<lastcell;j++) {
				data[i][j]=sh.getRow(i+1).getCell(i).getStringCellValue();
			}
		}
		return data;
		
	}
}
