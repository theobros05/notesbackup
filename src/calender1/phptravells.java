package calender1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import java.util.concurrent.TimeUnit;



public class phptravells {

	
	public static void main(String[] args) throws Exception {
		WebDriver driver;
		
		driver = new ChromeDriver();
		driver.get("http://www.phptravels.net");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
// search box
        
        driver.findElement(By.linkText("Search by Hotel or City Name")).click();
        driver.findElement(By.cssSelector("input.select2-input.select2-focused")).sendKeys("dubai");
        Thread.sleep(1000);
        new Actions(driver).moveToElement(driver.findElement(By.cssSelector("div.searchground"))).build().perform();
        new Actions(driver).moveToElement(driver.findElement(By.xpath("//div[@class='searchground']/div[2]"))).build().perform();
        driver.findElement(By.xpath(".//*[@id='select2-drop']/ul/li/ul/li[1]/div")).click();
       driver.findElement(By.cssSelector(".form.input-lg.dpd1")).click();
		Thread.sleep(2000);
		
		// calender 2
		String em = "November 2017";
		driver.findElement(By.xpath("html/body/div[13]/div[1]/table/thead/tr[1]/th[3]")).click();
		String cm=driver.findElement(By.xpath("html/body/div[13]/div[1]/table/thead/tr[1]/th[2]")).getText();
		if (em.equals(cm)) {
			System.out.println("month--"+em); 
		}
		else {
			for(int i=1;i<12;i++) {
				driver.findElement(By.xpath("html/body/div[13]/div[1]/table/thead/tr[1]/th[3]")).click();
				Thread.sleep(2000);
				cm=driver.findElement(By.xpath("html/body/div[13]/div[1]/table/thead/tr[1]/th[2]")).getText();
				if (em.equals(cm)) {
					System.out.println("month  selected is--"+cm); 
					break;
			}
		}
	}
		
		// calender 2
		Thread.sleep(2000);
		WebElement datepicker = driver.findElement(By.xpath("html/body/div[13]/div[1]/table/tbody/tr[3]/td[3]"));
		datepicker.click();
		Thread.sleep(2000);	
		driver.findElement(By.cssSelector(".form.input-lg.dpd2")).clear();
		Thread.sleep(2000);
		String ExpsMonth = "December 2017";
		driver.findElement(By.xpath("html/body/div[14]/div[1]/table/thead/tr[1]/th[3]")).click();
		String CurrsMonth=driver.findElement(By.xpath("html/body/div[14]/div[1]/table/thead/tr[1]/th[2]")).getText();
		if (ExpsMonth.equals(CurrsMonth)) {
			System.out.println("month--"+em); 
	}
		else {
		for(int i=1;i<12;i++) {
			driver.findElement(By.xpath("html/body/div[14]/div[1]/table/thead/tr[1]/th[3]")).click();
			Thread.sleep(2000);
			CurrsMonth=driver.findElement(By.xpath("html/body/div[14]/div[1]/table/thead/tr[1]/th[2]")).getText();
			if (ExpsMonth.equals(CurrsMonth)) {
				System.out.println("month selected is--"+cm); 
				break;
		}
	} 
}
	Thread.sleep(2000);
	WebElement datepicker1 = driver.findElement(By.xpath("html/body/div[14]/div[1]/table/tbody/tr[3]/td[5]"));
	datepicker1.click();
	Thread.sleep(3000);
	driver.findElement(By.id("adults")).click();
	Thread.sleep(2000);
	// To select the number of adults
	new Select(driver.findElement(By.id("adults"))).selectByVisibleText("4");
	
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	driver.findElement(By.xpath("//h4/a/b")).click();
	
	// to click all the images
	for(int i=0;i<10;i++) {
	driver.findElement(By.xpath(".//*[@id='OVERVIEW']/div/div[2]/div[1]/div[3]/div[2]/div/div[1]/div[3]")).click();
	Thread.sleep(1000);
}
	driver.quit();
}
}