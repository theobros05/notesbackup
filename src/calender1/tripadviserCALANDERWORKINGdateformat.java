package calender1;
import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;
import java.text.SimpleDateFormat;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.openqa.selenium.OutputType.*;

public class tripadviserCALANDERWORKINGdateformat {
    public static void main(String[] args) throws Exception {
        
        
       
        
        // To disintegrate the date
    	String seldate="12/12/2017"; // give date in computer format
    	
    	// formating month to site format.
        Date date = new Date(seldate);
        
        SimpleDateFormat dt= new  SimpleDateFormat("MMM yyyy");
	    String month=dt.format(date);
        System.out.println(month+"---the formated month");
        
        // formatting date to site format.// 2017-11-25 one month less than the current one
        
         SimpleDateFormat datch= new  SimpleDateFormat("yyyy/MM/dd");
        
         String cc=datch.format(date);
        
         String[] split= cc.split("/");
         
         System.out.println(split[0]+"-"+split[1]+"-"+split[2]);
         
         String s=split[1];
         
         int i=Integer.parseInt(s);   			// converting to int	
         
         String str = Integer.toString(i-1);   	// subracting the value	
         
         String[] ary = str.split(" ");			//changing string to array	
        
         
         
         // changed format to site date 2017-11-25 one month less than the current one
         
         
         String dat=split[0]+"-"+ary[0]+"-"+split[2];
         
         System.out.println(dat);  
         
        ChromeDriver driver;
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS); 
        driver.get("https://www.tripadvisor.in/");
        
        driver.findElement(By.xpath("//span[text()='Check In']")).click();
        Thread.sleep(3000);
                  
          for(int it=1; it<12;it++)  
          {
        	  String mt=driver.findElement(By.cssSelector("div span[class='dsdc-month-title']")).getText();
              System.out.println(mt);
            if(mt.equals(month))
            {
            	System.out.println("if loop matching");
            	Thread.sleep(2000);
            	// click on the date
            	driver.findElement(By.xpath("//div[@class='dsdc-months']//span[@data-date='"+dat+"']")).click();
            	// own xpath
            	Thread.sleep(2000);
            	
            
            	System.out.println("date clicked");
            	System.out.println(month+"month is already selected");
            	
            	break;
            	               
            }
        
            else {
            	 // to click next month button
            	driver.findElement(By.cssSelector("div [class='dsdc-next ui_icon single-chevron-right-circle']")).click();
            	Thread.sleep(1000);
            	
            	}
            }
           
   
     driver.quit(); 
        }
   
}

