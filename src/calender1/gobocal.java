package calender1;

import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import static org.openqa.selenium.OutputType.*;

public class gobocal {
	
	
	//Logger log = Logger.getLogger("mylogger");

	private static final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    public static void main(String[] args) throws Exception {
    	//BasicConfigurator.configure();	
    	String seldate="09/20/2017";
        Date d = new Date(seldate);
        
        SimpleDateFormat dt= new  SimpleDateFormat("MMMM/dd/yyyy");
        
        String date=dt.format(d);
        System.out.println(date);
        
        String[] split= date.split("/");
        
        System.out.println(split[0]+"--"+split[1]+"--"+split[2]);
        
        String month=split[0]+" "+split[2];
        
        System.out.println("month and year----"+month);
        
        // formating date for gobibo site             // .//*[@id='fare_20170819'] the exact date

        
        
        SimpleDateFormat gg= new  SimpleDateFormat("yyyyMMdd");
        
        String dat=gg.format(d);
        
        System.out.println(dat);
        
        
        String fp=".//*[@id='fare_";
        
        String lp="']";
        
        String finalp=fp+dat+lp;
        
        System.out.println("dynamic xpath"+finalp);  
		
	
      ChromeDriver driver;
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get("https://www.goibibo.com/");
        
       Thread.sleep(3000);
       
       // click on one way radio button
        driver.findElement(By.xpath(".//*[@id='gi_oneway_label']")).click();
        Thread.sleep(3000);
        
        // clicking on start date calander
    	driver.findElement(By.xpath(".//*[@id='searchWidgetCommon']/div/div[3]/div[1]/div[1]/div/input")).click();
    	Thread.sleep(1000);
        
        System.out.println("dynamic xpath"+finalp);  

       
        while(true)
        {

        try{

            
        	//----//*[contains(text(),'August 2017')] to find the month name
        	
            driver.findElement(By.xpath("//*[contains(text(),'October 2017')]")).isDisplayed();
            Thread.sleep(2000);
           String a= "//*[contains(text(),'";
           String b="')]";
           
           String c=a+month+b;
           System.out.println("month xpath---"+c);  
        
         
          
           //driver.findElementByXPath("c").isDisplayed();
         Thread.sleep(1000);
         
         // .//*[@id='fare_20170819'] the exact date
         // .//*[@id='fare_20170820']
         
         
         
         driver.findElement(By.xpath(".//*[@id='fare_20170819']")).click();
         Thread.sleep(2000);
         System.out.println("try block working");  
         break;
         
        
        
        }
        			
       catch(Exception e)
       { System.out.println("catch block working");  

    	   driver.findElement(By.cssSelector(".DayPicker-NavButton.DayPicker-NavButton--next")).click();
    	   Thread.sleep(1000);
    	  
    	   
    	  // .//*[@id='searchWidgetCommon']/div/div[3]/div[1]/div[1]/div/div/div/div[1]/span[2] 
    	 System.out.println(e); 
       }
        
       }
        
       // driver.findElement(By.xpath("//div[@id='searchWidgetCommon']/div/div[3]/div[1]/div[2]/div/input[1]")).click();
       // driver.findElement(By.id("fare_20170914")).click();
       
        
       

  driver.quit(); }
    

}

    
