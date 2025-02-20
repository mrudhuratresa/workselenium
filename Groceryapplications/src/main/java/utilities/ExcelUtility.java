package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constands.Constants;



public class ExcelUtility {

	 static FileInputStream f;
	  static XSSFWorkbook w;
	  static XSSFSheet sh;
	  
	  public static String readUsenameData(int row,int col,String Sheet1 ) throws IOException {
	    
	    f=new FileInputStream(Constants.TEST_DATA_FILE);
	    w= new XSSFWorkbook(f);
	    sh= w.getSheet(Sheet1);
	    XSSFRow r = sh.getRow(row);
	    XSSFCell c = r.getCell(col);
	    return c.getStringCellValue();

	  }
	  
	  public static String readPasswordData(int row,int col,String Sheet1 ) throws IOException {
	    f=new FileInputStream(Constants.TEST_DATA_FILE);
	    w= new XSSFWorkbook(f);
	    sh= w.getSheet(Sheet1);
	    XSSFRow r = sh.getRow(row);
	    XSSFCell c = r.getCell(col); 
	    return c.getStringCellValue();
	  
	  }
	

	 
}
