package automation;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class deleterowfind{

	public static Logger log = Logger.getLogger("myLogger"); 

private static String[] links = null;
private static int linksCount = 0;
int i;
public static void main(String[] args) throws Throwable {

     WebDriver driver = new ChromeDriver();
     driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    // BasicConfigurator.configure();	
		File file = new File("D:\\workspace new\\calender\\src\\automation\\data.properties");
		FileInputStream fileInput;
		fileInput = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fileInput);
		
		 driver.get(prop.getProperty("URL")); 
		 log.info("Opening Techfetch webiste");
		 Thread.sleep(2000);
		 
		 driver.findElement(By.xpath(".//*[@id='ucHeaderCtrl_divCandidate']/a")).click(); 
		 log.info("Opening candidate menu");
		 driver.findElement(By.xpath(".//*[@id='jsloginpop']")).click();
		 log.info("Clicking Login button");
		 driver.switchTo().frame("candidatecontentframe");
		 
		 driver.findElement(By.id("txtemailid")).sendKeys(prop.getProperty("Username"));  
		 
		 log.info("Entering email id");
		 driver.findElement(By.id("txtpwd")).sendKeys(prop.getProperty("Password")); 
		 log.info("Entering password");
		 Thread.sleep(2000);
		 driver.findElement(By.id("btnSubmit")).click();
		 log.info("Clicking submit button");
		 
		 Thread.sleep(2000);
		 
		 
		// Grab the table 
		 WebElement table = driver.findElement(By.id("ucMoreResumes_lblJobs")); 

		 // Now get all the TR elements from the table 
		 List<WebElement> allRows = table.findElements(By.tagName("tr")); 

		 // And iterate over them, getting the cells 
		 for (WebElement row : allRows) { 
		     List<WebElement> cells = row.findElements(By.tagName("td")); 

		     // Print the contents of each cell
		     for (WebElement cell : cells) { 
		         System.out.println(cell.getText());
		     }
		 }
		 
		      
    Thread.sleep(3000);
}}