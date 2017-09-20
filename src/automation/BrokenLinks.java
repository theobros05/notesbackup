package automation;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {
    
    private static WebDriver driver = null;

    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub
        
        String homePage = "http://www.techfetch.com/";
        String url = "";
        HttpURLConnection huc = null;
        int respCode = 200;
        
    	System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe"); 

        driver = new ChromeDriver();
        
      //  driver.manage().window().maximize();
        
        driver.get(homePage);
        
        List<WebElement> links = driver.findElements(By.xpath("//ul[@class='home dropdown-menu']//li/a"));
        
        Iterator<WebElement> it = links.iterator();
        
        while(it.hasNext()){
            
            url = it.next().getAttribute("href");
            
            System.out.println(url);
        
            if(url == null || url.isEmpty()){
System.out.println("URL is either not configured for anchor tag or it is empty");
                continue;
            }
            
            if(!url.startsWith(homePage)){
                System.out.println("URL belongs to another domain, skipping it.");
                continue;
            }
            
            try {
                huc = (HttpURLConnection)(new URL(url).openConnection());
                
                huc.setRequestMethod("HEAD");
                
                huc.connect();
                
                respCode = huc.getResponseCode();
                
                if(respCode >= 400){
                    System.out.println(url+" is a broken link");
                    
             
                }
                else{
                    System.out.println(url+" is a valid link");
                    
                    driver.navigate().to(url);
                    Thread.sleep(2000);
                    driver.navigate().back();
                    continue;
                }
                    
            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
        driver.quit();

    }
}