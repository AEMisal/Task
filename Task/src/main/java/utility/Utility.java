package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import base.Baseclass;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Utility
{
	public static String getDataFromPropertyFile(String Key) throws IOException
	{
		Properties prop=new Properties();
		FileInputStream myfile=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\propertyFile\\object.properties");
		prop.load(myfile);
		String value = prop.getProperty(Key);
		return value;
	}

	public static String readDataFromExcel(int row, int cell) throws  EncryptedDocumentException, IOException  
	{
		File myfile= new File(System.getProperty("user.dir")+"\\src\\main\\java\\propertyFile\\TestData.xlsx");
		Sheet mySheet = WorkbookFactory.create(myfile).getSheet("DataSheet");
		String value = mySheet.getRow(row).getCell(cell).getStringCellValue();
		return value;
	}

}
