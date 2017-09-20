package automation;
import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileNotFoundException;  
import java.io.IOException;  
import java.util.Properties;  
import org.openqa.selenium.By;  
import org.openqa.selenium.NoSuchElementException;  
import org.openqa.selenium.WebDriver;  
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;  
import org.testng.annotations.Test;


 public class checkingWITHRESOUSEFILE {
	 
	 static String workdir = System.getProperty("user.dir");
@Test()
 public static void main(String[] args) throws InterruptedException
 {  
	
 try {  
 
 FileInputStream fileInput = new FileInputStream(new File(workdir+"\\Resources\\data.properties"));  

 Properties prop = new Properties();  

 prop.load(fileInput);  
 
 System.setProperty("webdriver.chrome.driver",workdir+"\\Resources\\chromedriver.exe");
 WebDriver driver = new ChromeDriver(); 
 
 driver.get("http://www.google.com");
 
 

 Thread.sleep(3000);
 
 String workdir = System.getProperty("user.dir");
 
 System.out.println("the current working directory   "+workdir);
 
 //Print Properties Values  
 System.out.println("URL    =: " + prop.getProperty("URL"));  
 System.out.println("User name =: " + prop.getProperty("Username"));  
 System.out.println("Password =: " + prop.getProperty("Password"));  
 Thread.sleep(2000);
 // Browser close    
 driver.close();
   
     } catch (FileNotFoundException e) {  
 e.printStackTrace();  
     } catch (IOException e) {  
 e.printStackTrace();  
     } catch (NoSuchElementException e) {  
    	 
    	 
 e.printStackTrace();  
     }  
 }}
