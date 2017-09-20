package automation;

import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
 
public class FileUpload {
 
@Test
public void Fileupload() throws AWTException, InterruptedException{
 
 
// Start browser
 WebDriver driver = new ChromeDriver();
 
 
 
// maximize browser
 driver.manage().window().maximize();
        
  // Specify the file location with extension
 StringSelection sel = new StringSelection("C:\\Users\\mag9\\Desktop\\Resume.doc");
 
   // Copy to clipboard
 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel,null);
 System.out.println("selection" +sel);
 
 
// Open Monster.com
 driver.get("C:\\Users\\mag9\\Desktop\\fileupload.html");
 Thread.sleep(2000);
 
 // This will scroll down the page 
// JavascriptExecutor js = (JavascriptExecutor)driver;
 //js.executeScript("scroll(0,350)");
 
// Wait for 5 seconds
 Thread.sleep(5000);
 
// This will click on Browse button
 driver.findElement(By.name("resumeupload")).click();
 
 
 
 System.out.println("Browse button clicked");
 
 // Create object of Robot class
 Robot robot = new Robot();
 Thread.sleep(1000);
      
  // Press Enter
 robot.keyPress(KeyEvent.VK_ENTER);
 
// Release Enter
 robot.keyRelease(KeyEvent.VK_ENTER);
 
  // Press CTRL+V
 robot.keyPress(KeyEvent.VK_CONTROL);
 robot.keyPress(KeyEvent.VK_V);
 
// Release CTRL+V
 robot.keyRelease(KeyEvent.VK_CONTROL);
 robot.keyRelease(KeyEvent.VK_V);
 Thread.sleep(1000);
        
        // Press Enter 
 robot.keyPress(KeyEvent.VK_ENTER);
 robot.keyRelease(KeyEvent.VK_ENTER);
 
}
 
}