package winframe;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class frame {


	static WebDriver driver;

	
	public static void main(String[] args) throws InterruptedException 
	{
		// for Mac OS
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
		// For Window OS
		// System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://only-testing-blog.blogspot.in/2015/01/iframe1.html");
		
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,150)");
		Thread.sleep(3000);
		driver.switchTo().frame("frame1");
		
		
		
		driver.findElement(By.xpath(".//*[@id='post-body-3107268830657760720']/div[1]/table/tbody/tr[1]/td[1]/input")).click();
		
		Thread.sleep(3000);
		
		

		driver.quit();
		
		
	/*	//a[contains(@href,'../p36iframes/index.html')]

		int o= driver.findElements(By.tagName("frame")).size();
		
		System.out.println(o);

		for(int i =0;i<=o;i++)

		{

		driver.switchTo().frame(i);

		//find the element-button1 and check if its size if >0,if yes you are in right frame

		WebElement button=driver.findElement(By.xpath("//a[contains(@href,'../p36iframes/index.html')]"));

		if(button.getSize().equals("0") )

		button.click();

		break;

		}*/
		
		
	}
}
