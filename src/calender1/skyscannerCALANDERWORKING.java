package calender1;
import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.util.List;
import java.io.File;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.OutputType.*;

public class skyscannerCALANDERWORKING{ // working with if else conditions.
    public static void main(String[] args) throws Exception {
        ChromeDriver wd;
        wd = new ChromeDriver();
     
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.get("https://www.skyscanner.co.in/");
        Thread.sleep(1000);
        // click on calender
        wd.findElement(By.xpath(".//*[@id='js-depart-input']")).click();
        Thread.sleep(2000);
        String month="March 2018";
        
     
         // to get the current month from the calender
        String cm=wd.findElement(By.cssSelector("div.depart span[class='current']")).getText();
        
        System.out.println(cm);
        
        if(cm.equalsIgnoreCase(month))
        {
        	System.out.println(month+"month is already selected");
        }
        
        // to iterate through the month name and select the required month
        else
        {
       
        	System.out.println(month+"---month is not  selected");
        	
        	for(int i=1;i<12;i++)
        	{
        		wd.findElement(By.cssSelector("div.depart button[class*='next']")).click();
        		Thread.sleep(1000);
        		cm=wd.findElement(By.cssSelector("div.depart span[class='current']")).getText();
        		if(cm.equalsIgnoreCase(month))
                {
                	System.out.println(month+"month is now selected");
                	break;
                }
        		
        	}
        }
        
        // check the table and iterate through the td and get the reqiured date
        Thread.sleep(2000);
        WebElement dp= wd.findElement(By.cssSelector("div.depart div.container-body tbody"));
        
        List<WebElement> date=dp.findElements(By.tagName("td"));
        
        for(WebElement s : date)
        {
      	  System.out.println(s.getText()+"------");
      	  
      	  String c=s.getAttribute("data-id");
      	  
      	  if(c.equals("2018-03-10"))
      	  {
      		  s.click();
      		  break;
      		  
      	  }
        }
        
      
        wd.quit();
    }
    
	public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
