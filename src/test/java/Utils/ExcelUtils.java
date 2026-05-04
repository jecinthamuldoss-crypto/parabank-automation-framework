package Utils;

import java.io.FileInputStream;
import java.io.IOException;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	public static String getCellData(String sheetName, int rowNum, int colNum) throws IOException {

	FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "/src/test/resources/testdata/LoginData.xlsx");
	XSSFWorkbook workbook = new XSSFWorkbook(fis);
	XSSFSheet sheet = workbook.getSheet(sheetName);
	XSSFRow row = sheet.getRow(rowNum);
	XSSFCell cell = row.getCell(colNum);
	
	String value = cell.getStringCellValue();
	workbook.close();
	fis.close();
	return value;
	
	
	
	
	
	
	}
}


