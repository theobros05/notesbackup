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


 public class deletingresumescandidate {  
@Test()
 public static void main(String[] args) throws InterruptedException
 {  
	
 try {  
 
 FileInputStream fileInput = new FileInputStream(new File("D:\\workspace new\\Techfetch\\src\\automation\\data.properties"));  

 Properties prop = new Properties();  

 prop.load(fileInput);  
 
 System.setProperty("webdriver.chrome.driver","D://chromedriver.exe");
 WebDriver driver = new ChromeDriver();  
  
driver.manage().window().maximize();  

 
 driver.get(prop.getProperty("URL")); 
 Thread.sleep(2000);
 driver.findElement(By.xpath(".//*[@id='ucHeaderCtrl_divCandidate']/a")).click(); 
 driver.findElement(By.xpath(".//*[@id='jsloginpop']")).click();
 driver.switchTo().frame("candidatecontentframe");
 driver.findElement(By.id("txtemailid")).sendKeys(prop.getProperty("Username"));  
 driver.findElement(By.id("txtpwd")).sendKeys(prop.getProperty("Password")); 
 Thread.sleep(2000);
 driver.findElement(By.id("btnSubmit")).click();  
 Thread.sleep(2000);
 
 driver.switchTo().frame("contentframe");
 
 

 
 
 driver.findElement(By.xpath(".//*[@id='ucMoreResumes_lblJobs']/table/tbody/tr[1]/td[7]/a/img")).click();
 
 System.out.println("delete button clicked on content frame");
 
 driver.switchTo().defaultContent();
 
 
  driver.switchTo().frame("deleteprofilecontentframe");
 
 System.out.println("switched to delete profile content frame");
 Thread.sleep(1000);
 
 System.out.println("To make profile confidential");
 
 driver.findElement(By.xpath(".//*[@id='rdConfidential']")).click();
 Thread.sleep(3000);
 driver.findElement(By.xpath(".//*[@id='btnDelete']")).click();
 System.out.println("submit button clicked");
 Thread.sleep(1000);
 
 

 driver.switchTo().defaultContent();
 
 driver.switchTo().frame("contentframe");
 
 driver.findElement(By.xpath(".//*[@id='ucMoreResumes_lblJobs']/table/tbody/tr[1]/td[7]/a/img")).click();
 
System.out.println("delete button clicked on content frame");
Thread.sleep(1000);
driver.switchTo().defaultContent();

driver.switchTo().frame("deleteprofilecontentframe");

System.out.println("To click Make My Resume NOT Available");

driver.findElement(By.xpath(".//*[@id='rdNotAvailable']")).click();
Thread.sleep(2000);
driver.findElement(By.xpath(".//*[@id='btnDelete']")).click();
System.out.println("submit button clicked");
Thread.sleep(3000);


driver.switchTo().defaultContent();

driver.switchTo().frame("contentframe");

driver.findElement(By.xpath(".//*[@id='ucMoreResumes_lblJobs']/table/tbody/tr[1]/td[7]/a/img")).click();

System.out.println("delete button clicked on content frame");
Thread.sleep(1000);
driver.switchTo().defaultContent();

driver.switchTo().frame("deleteprofilecontentframe");

System.out.println("Delete My Profile Permanently");

driver.findElement(By.xpath(".//*[@id='rdDelete']")).click();

driver.findElement(By.xpath(".//*[@id='btnDelete']")).click();
System.out.println("submit button clicked");
Thread.sleep(3000);

driver.switchTo().defaultContent();

driver.switchTo().frame("deleteprofilecontentframe");

driver.findElement(By.xpath(".//*[@id='rdbtnParttimeno']")).click();

System.out.println("clicking to save and deactivate");



 Thread.sleep(3000);
 
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
