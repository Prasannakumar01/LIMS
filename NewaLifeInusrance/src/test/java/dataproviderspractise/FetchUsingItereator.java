package dataproviderspractise;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchUsingItereator {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		FileInputStream fis = new FileInputStream(
				"D:\\Selenium and java Practice\\NewaLifeInusrance\\testdata\\LData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheetAt(0);

		Iterator<Row> it = sh.iterator();
		while (it.hasNext()) {
			Row row =  it.next();
			Iterator<Cell> cellIterator = row.cellIterator();
			while (cellIterator.hasNext()) {
				Cell cell = cellIterator.next();

				switch (cell.getCellType()) {
				case STRING:
					System.out.print(cell.getStringCellValue());
					break;
				case NUMERIC:
					System.out.print(cell.getNumericCellValue());
					break;

				case BOOLEAN:
					System.out.print(cell.getStringCellValue());
					break;
				default:
					System.out.print(cell.getRichStringCellValue());
					break;
				}
				System.out.print("   |   ");
			}
			System.out.println();
		}

	}

}
