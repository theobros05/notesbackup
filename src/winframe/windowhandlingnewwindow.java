package winframe;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


/*
* Open a link in a new window and switch to it:
*
*/

public class windowhandlingnewwindow {

public static void main(String[] args) throws InterruptedException {

//set chromedriver path for Chrome browser

//create WebDriver object for Chrome
WebDriver driver=new ChromeDriver();

//open URL
driver.get("http://www.americangolf.eu/");
// Storing parent window reference into a String Variable  
String parentWindow=driver.getWindowHandle();
System.out.println("Parent Window Title "+driver.getTitle());


for (String Child_Window : driver.getWindowHandles())  
{  
driver.switchTo().window(Child_Window);  

WebElement lin = driver.findElement(By.xpath(".//*[@id='header-top-wrapper']/div/div[3]/div[1]/div/ul/li[1]/a"));
Actions newTa = new Actions(driver);
newTa.keyDown(Keys.SHIFT).click(lin).keyUp(Keys.SHIFT).build().perform();
}
driver.switchTo().window(parentWindow);  

WebElement link = driver.findElement(By.xpath(".//*[@id='header-navigation']/div[1]/ul/li[2]/a"));
Actions newTab = new Actions(driver);
newTab.keyDown(Keys.SHIFT).click(link).keyUp(Keys.SHIFT).build().perform();
Thread.sleep(5000);
driver.switchTo().window(parentWindow);  
System.out.println("Parent Window Title222 "+driver.getTitle());

/*
//handle windows change
String base = driver.getWindowHandle();
Set<String> set = driver.getWindowHandles();



 
set.remove(base);
assert set.size() == 1;
driver.switchTo().window((String) set.toArray()[0]);
 
//close the window
//driver.close();
driver.switchTo().window(base);
 
// handle windows change and switch back to the main window
Thread.sleep(2500);
for (String winHandle : driver.getWindowHandles()) {
driver.switchTo().window(winHandle);
}*/











/*
//maximize the window
//driver.manage().window().maximize();

WebElement link = driver.findElement(By.xpath(".//*[@id='header-navigation']/div[1]/ul/li[1]/a"));
Actions newTab = new Actions(driver);
newTab.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).click(link).keyUp(Keys.CONTROL).keyUp(Keys.SHIFT).build().perform();
Thread.sleep(3000);
System.out.println(" 2nd title "+driver.getTitle());


driver.switchTo().window(parentWindow);

WebElement lin = driver.findElement(By.xpath(".//*[@id='header-navigation']/div[1]/ul/li[2]/a"));
Actions newTa = new Actions(driver);
newTa.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).click(lin).keyUp(Keys.CONTROL).keyUp(Keys.SHIFT).build().perform();
Thread.sleep(3000);
System.out.println("3rd title "+driver.getTitle());
driver.switchTo().window(parentWindow);

Set<String> windows = driver.getWindowHandles();

Iterator iterator = windows.iterator();
while (iterator.hasNext()) {
	
	String w1 = iterator.next().toString(); System.out.println(w1);
	String w2 = iterator.next().toString();System.out.println(w2);
	String w3 = iterator.next().toString();System.out.println(w3);
	
	driver.switchTo().window(w2);

}

WebElement li = driver.findElement(By.xpath(".//*[@id='header-top-wrapper']/div/div[3]/div[1]/div/ul/li[1]/a"));
Actions newT = new Actions(driver);
newT.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).click(li).keyUp(Keys.CONTROL).keyUp(Keys.SHIFT).build().perform();
Thread.sleep(3000);
System.out.println("4rd title "+driver.getTitle());

//String currentWindow = driver.getWindowHandle(); 
Set<String> availableWindows = driver.getWindowHandles(); 
if (!availableWindows.isEmpty()) { 
     for (String windowId : availableWindows) {
          String switchedWindowTitle=driver.switchTo().window(windowId).getTitle();
          if ((switchedWindowTitle.equals("Golf Clubs and Golf Equipment Online - American Golf"))||(switchedWindowTitle.contains("Golf Clubs from american golf Europe's Largest Golf Retailer"))){ 
               
          } else { 
            driver.switchTo().window(parentWindow); 
          } 
      } 
 } 
*/


/*for(String handle:driver.getWindowHandles())
{
System.out.println(handle);
driver.switchTo().window(handle);*/

}

}
