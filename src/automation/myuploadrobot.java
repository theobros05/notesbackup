package automation;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
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


 public class myuploadrobot {  
@Test()
 public static void main(String[] args) throws InterruptedException, AWTException
 {  
	
 try {  
 
 FileInputStream fileInput = new FileInputStream(new File("D:\\workspace new\\Techfetch\\src\\automation\\data.properties"));  

 Properties prop = new Properties();  

 prop.load(fileInput);  
 
 System.setProperty("webdriver.chrome.driver","D://chromedriver.exe");
 WebDriver driver = new ChromeDriver();  
  
//driver.manage().window().maximize();  

// Specify the file location with extension
StringSelection sel = new StringSelection("C:\\Users\\mag9\\Desktop\\stephen_clarous.docx");

  // Copy to clipboard
Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel,null);

System.out.println("selection"+sel);

 
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
 
 driver.findElement(By.xpath(".//*[@id='ucMoreResumes_lblJobs']/table/tbody/tr[3]/td[4]/a/img")).click(); 
 Thread. sleep (1000);
 
driver.switchTo().defaultContent();

driver.switchTo().frame("replacedoccontentframe");

 Thread.sleep(1000);
 
 
   
driver.findElement(By.xpath(".//*[@id='dupupload2']/div/div/div")).click();

//Create object of Robot class
Robot robot = new Robot();
Thread.sleep(1000);
   
// Press Enter
robot.keyPress(KeyEvent.VK_ENTER);

//Release Enter
robot.keyRelease(KeyEvent.VK_ENTER);

// Press CTRL+V
robot.keyPress(KeyEvent.VK_CONTROL);
robot.keyPress(KeyEvent.VK_V);

//Release CTRL+V
robot.keyRelease(KeyEvent.VK_CONTROL);
robot.keyRelease(KeyEvent.VK_V);
Thread.sleep(1000);
     
     // Press Enter 
robot.keyPress(KeyEvent.VK_ENTER);
robot.keyRelease(KeyEvent.VK_ENTER);

System.out.println(" file input given    ");  

Thread.sleep(10000);
driver.findElement(By.xpath(".//*[@id='btnSubmit']")).click();
Thread.sleep(3000);
driver .findElement(By.id("btnClose")).click(); 
	

 
 
 
 Thread.sleep(3000);
 
 //Print Properties Values  
 System.out.println("URL    =: " + prop.getProperty("URL"));  
 System.out.println("User name =: " + prop.getProperty("Username"));  
 System.out.println("Password =: " + prop.getProperty("Password"));  
 Thread.sleep(2000);
 // Browser close    
// driver.close();
   
     } catch (FileNotFoundException e) {  
 e.printStackTrace();  
     } catch (IOException e) {  
 e.printStackTrace();  
     } catch (NoSuchElementException e) {  
 e.printStackTrace();  
     }  
 }}

