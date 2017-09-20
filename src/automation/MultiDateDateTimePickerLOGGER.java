package automation;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
 
public class MultiDateDateTimePickerLOGGER  {
	
	Logger log;
	
	//Logger log = Logger.getLogger("deypinoyLogger"); 
	
	//Propertyconfigurator.configure(Logger.properties);
	//BasicConfigurator.configure(Logger.properties);
	private String demosite = "http://jqueryui.com/resources/demos/datepicker/other-months.html";
 
	WebDriver browser;
	WebDriverWait wait;
 
	@BeforeTest
	public void startTest() {
		BasicConfigurator.configure();
	   log = Logger.getLogger("myLogger"); 
		// Launch the demo site to handle date time picker.
		browser = new ChromeDriver();
		//browser.manage().window().maximize();
		browser.navigate().to(demosite);
		  log.debug("opening the browser");
	}
 
	@Test
	public void jQueryCalendarMultipleMonths() throws InterruptedException {
		
		// Start the date time picker demo website.
		browser.navigate().to(demosite);
	      log.debug("opening the site");
		// click to open the date time picker calendar.
		WebElement calElement = browser.findElement(By.id("datepicker"));
		calElement.click();
		Thread.sleep(3000);
	      log.debug("finding the calender");
		// Provide the day of the month to select the date.
		SelectDayFromMultiDateCalendar("5");
		Thread.sleep(3000);
	}
 
	// Function to select the day of month in the date picker.
	public void SelectDayFromMultiDateCalendar(String day)
			throws InterruptedException {
	      log.debug("Seleting the date");
		// We are using a special XPath style to select the day of current
		// month.
		// It will ignore the previous or next month day and pick the correct
		// one.
		By calendarXpath = By.xpath("//td[not(contains(@class,'ui-datepicker-other-month'))]/a[text()='"+ day + "']");
		browser.findElement(calendarXpath).click();
		log.debug("show the result of the date");
		// Intentional pause for 2 seconds.
		Thread.sleep(3000);
	}
 
	@AfterTest
	public void endTest() {
		browser.quit();
		log.debug("closing the brower");
	}
}