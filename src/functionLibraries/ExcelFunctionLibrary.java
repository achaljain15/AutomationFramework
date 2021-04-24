package functionLibraries;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import configurations.Configuration;

public  class ExcelFunctionLibrary  {	
	XSSFWorkbook wb;
	String path;
		public ExcelFunctionLibrary(String testdatapath) {
		// TODO Auto-generated constructor stub
			path=Configuration.testDataPath;
	}

		public String getCellData(String sheetname, int rowNumber , int columnNumber) throws IOException
	{
			FileInputStream file= new FileInputStream(path);
			wb=new XSSFWorkbook(file);
	XSSFSheet sheet = wb.getSheet(sheetname);
	XSSFRow row= sheet.getRow(rowNumber);
	XSSFCell cell= row.getCell(columnNumber); 
	String data= cell.getStringCellValue();
	//System.out.println(data);
	return data;		
	}
		
		public int getRowCount(String sheetname) throws IOException {
			FileInputStream file= new FileInputStream(path);
			 wb=new XSSFWorkbook(file);
			XSSFSheet sheet = wb.getSheet(sheetname);
			return sheet.getPhysicalNumberOfRows();	
		}

		public int getColumnCount(String sheetname, int rowNum) throws IOException {
			FileInputStream file= new FileInputStream(path);
			 wb=new XSSFWorkbook(file);
			XSSFSheet sheet = wb.getSheet(sheetname);
			return sheet.getRow(rowNum).getPhysicalNumberOfCells();
		}
		
		public int getColumnCount(String sheetname) throws IOException {
			FileInputStream file= new FileInputStream(path);
			 wb=new XSSFWorkbook(file);
			XSSFSheet sheet = wb.getSheet(sheetname);
			return sheet.getRow(0).getPhysicalNumberOfCells();
		}
}

