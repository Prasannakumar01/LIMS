package dataproviderspractise;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchdataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream("D:\\Selenium and java Practice\\NewaLifeInusrance\\testdata\\LIM_Data.xlsx");
		Workbook wb ;
		wb = WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("sheet2");
		
		int rowcount=sh.getLastRowNum();
		int cellcount=sh.getRow(0).getLastCellNum();

		for(int row=0;row<rowcount;row++) {
			Row rowvalue= sh.getRow(row);
			for(int cell=0;cell<cellcount;cell++) {
				Cell cellvalue=rowvalue.getCell(cell);
				switch(cellvalue.getCellType()) {
				case STRING:
					System.out.print(cellvalue.getStringCellValue());
					break;
				case NUMERIC:
					System.out.print(cellvalue.getNumericCellValue());
					break;
				case BOOLEAN:
					System.out.print(cellvalue.getBooleanCellValue());
					break;
				default:
					break;

				}
				System.out.print("       ->       ");
			}
			System.out.println();  

		}
	}
	}

		/*	@DataProvider
	public Object fetchdatafromExcel(){
		Object[][] obj= new Object[2][2];

		obj[0][0]=
	          return obj;


	}*/

	
