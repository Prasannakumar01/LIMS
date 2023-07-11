package dataproviderspractise;

import java.io.FileInputStream;
import java.io.IOException;

import org.NewaInsurance_GenrericUtilities.FileUtilities;
import org.NewaInsurance_GenrericUtilities.IconstantUtitlity;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class XLreading {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		XLreading xl = new XLreading();
		System.out.println(xl.get("fis", "Sheet1", 2, 4));

		FileUtilities flib = new FileUtilities();

		String filepath = flib.getFilepathfromProperties("excelpath");

		try {
			FileInputStream fis = new FileInputStream(filepath);
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet("dataproviders");
			Row row = sh.getRow(0);
			int cell = row.getLastCellNum();
			// String value=cell.getStringCellValue();
			// System.out.println(value);
			System.out.println(cell);
			// System.out.println(row);
			// System.out.println(sh);

		} catch (IOException | EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

	public String get(String filepath, String sheet, int row, int cell) throws EncryptedDocumentException, IOException {

		FileInputStream fis = new FileInputStream(IconstantUtitlity.excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheet);
		Row r = sh.getRow(row);
		Cell c = r.getCell(cell);
		String value = c.getStringCellValue();
		return value;

	}
}
