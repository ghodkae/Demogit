package UtilityClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import ConfigurationPath.Configuration;

public class UtilityClass {

	public String getTestData(int row, int coloumn) throws EncryptedDocumentException, IOException
	{
		FileInputStream file= new FileInputStream(Configuration.excelsheet);
		Sheet sheet = WorkbookFactory.create(file).getSheet("Sheet1");
		String value = sheet.getRow(row).getCell(coloumn).getStringCellValue();
		return value;
		
	}
	public  static void capatureScreenShot(WebDriver driver,String tcid) throws IOException
	{
		  File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  Date d= new Date();
		String sr= d.toString();
		sr=sr.replace(" ", "_");
		sr=sr.replace(":", "_");
		//System.out.println(sr);
		File dest = new File(Configuration.screenshot+tcid+sr+"image.jpeg");
		FileHandler .copy(src, dest);
				
	}
	public String readPropertyFiledata(String key) throws IOException
	{
		Properties prop= new Properties();
		FileInputStream file= new FileInputStream("D:\\zerodhaproject\\src\\main\\resources\\Configuration\\login.properties");
		prop.load(file);
		String value= prop.getProperty(key);
		return value;
		
	}
}
