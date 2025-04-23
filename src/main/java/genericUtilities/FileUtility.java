package genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * this file consists of generic methods related to file operation.
 * @sujata Beelur. 
 * 
 */


public class FileUtility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public String readDataFromPropertyFile(String key) throws IOException {
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commondata.properties");
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
	}
	/************
	 * This method read the data from excel file return the 
	 * value to caller
	 * @param sheetname
	 * @param rowNo
	 * @param CelNo
	 * @return
	 * @throws IOException
	 */

	public String readDataFromExcel(String sheetname,int rowNo,int CelNo) throws IOException {
		FileInputStream fis = new FileInputStream(".\\src\\main\\resources\\TestData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		String value = wb.getSheet(sheetname).getRow(rowNo).getCell(CelNo).getStringCellValue();
		return value;
		
		
		
	}
}
