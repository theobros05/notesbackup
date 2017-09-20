package automation;

import org.testng.annotations.Test;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.apache.commons.logging.Log;
import org.apache.log4j.*;
import org.openqa.selenium.*;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

//public String baseUrl;
//public  String driverPath;
//public WebDriver driver;

public class negativeTestNG {
	
	Logger log = Logger.getLogger("myLogger"); 
	
	
	
	private String resume = "http://uat.techfetch.com/JS/JS_My_Resume.aspx"; 
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeTest
	public void startTest() {
		//BasicConfigurator.configure();	
		// Launch techfetch site
		driver = new ChromeDriver();
		//browser.manage().window().maximize();
		
	}
	
	 @Test(priority = 0)
	public boolean login() throws IOException, InterruptedException 
	 {
		// Login to techfetch candidate
		/**
		 * @author Ben : login
		 */
		 
		 BasicConfigurator.configure();	
		File file = new File("D:\\workspace new\\Techfetch\\src\\automation\\data.properties");
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
		 
		 driver.switchTo().frame("contentframe");
		return true;
	}
	
	
	 @Test(priority = 1)
	    public void loginValidation() throws IOException, InterruptedException {   
		 log.info("resume validation test");
		 String actualTitle = driver.getCurrentUrl().toString();
	              
	      System.out.println(actualTitle);
	      try{
	    	  
	         Assert.assertTrue(login(),"User login not  completed");
            }
	      
	       	      
	      catch(AssertionError e){
	    	  
	    	
	    	   System.out.println("This catch error\n "+e);
	    	   log.info("Assert login completed");
	    	}
	      
	      
	       // Assert.assertEquals(actualTitle, resume);
	        //log.info("Assert completed");
		 
	 }
	 
	 @Test(priority = 2)
	    public void urlValidation() throws IOException, InterruptedException {   
		 log.info("resume validation test");
		 String actualTitle = driver.getCurrentUrl().toString();
	              
	      System.out.println(actualTitle);
	      try{
	    	  
	    	  Assert.assertEquals(actualTitle, resume);
         }
	      
	       	      
	      catch(AssertionError e){  
	   // negative test case for delete
	    	  
	    	  
	    	  
	    	  
	    	  
	    	
	    	   System.out.println("This catch error\n "+e);
	    	   log.info("Assert url completed");
	    	}
	      
	      
	       
		 
	 }
	 }
	

