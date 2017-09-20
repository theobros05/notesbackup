package automation;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class linkscheckpartialworking{


private static String[] links = null;
private static int linksCount = 0;
int i;
public static void main(String[] args) throws Throwable {

     WebDriver driver = new ChromeDriver();
     driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

     driver.get("http://uat.techfetch.com/JS/JS_My_Resume.aspx");
     
     List<WebElement> alllinks = driver.findElements(By.xpath("//ul[@class='home dropdown-menu']//li/a"));
     
     linksCount = alllinks.size();
     
     System.out.println("Number of links: "+linksCount);
     
     links= new String[linksCount];  
     
     //remove items from list (null, logoff... )
     
     String homeWindow = driver.getWindowHandle();


     // print all the links  
     System.out.println("List of links Available: ");  
     for(int i=0;i<linksCount;i++)
     {
     links[i] = alllinks.get(i).getAttribute("href");
     System.out.println(alllinks.get(i).getAttribute("href"));
     } 
     
     
     
    Thread.sleep(3000);
}}