package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel {
	public static String getDataFromExcelBasedTestId(String filePath, String sheetName , String testId, String columnHeader ) throws Throwable, IOException {
		FileInputStream fis1 = new FileInputStream(filePath);
		Workbook wb =  WorkbookFactory.create(fis1);
		Sheet sheet = wb.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		int testRowNum = 0;
		String actTestID="";
		String actColHeaderName="";
		String data="";
		
		for(int i=0; i<=rowCount; i++) {
			actTestID = sheet.getRow(i).getCell(0).toString();
			if(actTestID.equalsIgnoreCase(testId)) {
				break;				
			}
			testRowNum++;
		}
		int testColNum =0;
		int celCountforTest = sheet.getRow(testRowNum-1).getLastCellNum();
		for(int j=0; j<celCountforTest; j++) {
			actColHeaderName =  sheet.getRow(testRowNum-1).getCell(j).toString();
			
			if(actColHeaderName.equalsIgnoreCase(columnHeader)) {
				break;
			}
			testColNum++;
		}
		System.out.println(testRowNum);
		System.out.println(testColNum);
		data =  sheet.getRow(testRowNum).getCell(testColNum).toString();
		return data;
	}
	public static void main(String[] args) throws Throwable, Throwable {
		String Result = getDataFromExcelBasedTestId("./testdata/TestScriptdata.xlsx", "vendor", "TC_33", "Vendor Name");
		System.out.println(Result);
	}
	
}
