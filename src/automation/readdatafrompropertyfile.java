

package automation;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.lang.model.element.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertThat;

import com.gargoylesoftware.htmlunit.javascript.host.file.FileReader;
public class readdatafrompropertyfile {
public static void main(String[] args) throws InterruptedException {
try {
// Create FileInputStream Object


FileInputStream fileInput = new FileInputStream(new File("D:\\Sys1\\workspace\\Tech\\src\\july25\\dataproprties"));
// Create Properties object
Properties prop = new Properties();
//load properties file
prop.load(fileInput);
//// WebDriver reference but Firefox object
WebDriver driver; System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Java\\jdk1.8.0_121\\chromedriver.exe");
driver = new ChromeDriver();
//Maximize browser window
driver.manage().window().maximize();

//Visit to Facebook
driver.get(prop.getProperty("URL"));
Thread.sleep(2000);
//Read Username from Properties and send to facebook Username text field
driver.findElement(By.xpath(".//*[@id='ucHeaderCtrl_divCandidate']/a")).click();
Thread.sleep(2000);
driver.findElement(By.xpath(".//*[@id='jsloginpop']")).click();
//driver.manage().timeouts().implicitlywait();
driver.switchTo().defaultContent();

driver.switchTo().frame("candidatecontentframe");
driver.findElement(By.id("txtemailid")).sendKeys(prop.getProperty("Username"));
//Read Password from Properties and send to facebook password text field
driver.findElement(By.id("txtpwd")).sendKeys(prop.getProperty("Password"));
Thread.sleep(2000);
driver.findElement(By.xpath(".//*[@id='btnSubmit']")).click();
Thread.sleep(10000);
driver.switchTo().frame("contentframe");

driver.findElement(By.xpath(".//*[@id='ucMoreResumes_lblJobs']/table/tbody/tr[1]/td[4]")).click();
//driver.findElement(By.xpath(".//*[@id='resumeupload']")).sendKeys(prop.getProperty("FilePath"));
Thread.sleep(10000);
//driver.switchTo().frame("Replacedoccontentframe");
//driver.findElement(By.id("resumeupload")).sendKeys("D:\\Sys1\\BPK\\resume.docx");
//Thread.sleep(10000);
//String filename = "resume.docx";
//File file = new File(filename);
//String path = file.getAbsolutePath();
//driver.get("http://the-internet.herokuapp.com/upload");
Thread.sleep(1000);
driver.switchTo().defaultContent();
driver.switchTo().frame("replacedoccontentframe");
Thread.sleep(100);

driver.findElement(By.xpath(".//*[@id='dupupload2']/div/div/div")).click();
Thread.sleep(10000);

driver.findElement(By.id("btnSubmit")).click();
//Element element=sendkeys(path);
//driver.switchTo().defaultContent();


//System.out.println("file successfully uploaded");
/*String text = driver.findElement(By.id("uploaded-files")).getText();
System.out.println("file successfully uploaded");
assertThat(text, is(equalTo(filename)));*/


//driver.findElement(By.xpath(".//*[@id='btnSubmit']")).click();
Thread.sleep(10000);
System.out.println("file uploaded successfully");
//driver.get(prop.getProperty("uRL"));
if (driver.getPageSource().contains("Please re-enter your password")) {
System.out.println("--- Pass ---");
} else {
System.out.println("!!!! Fail !!!");
}
Thread.sleep(10000);

//Print Properties Values
System.out.println("URL =: " + prop.getProperty("URL"));
System.out.println("User name =: " + prop.getProperty("Username"));
System.out.println("Password =: " + prop.getProperty("Password"));

// Browser close
driver.close();

} catch (FileNotFoundException e) {
e.printStackTrace();
} catch (IOException e) {
e.printStackTrace();
} catch (NoSuchElementException e) {
e.printStackTrace();
}
}

private static Element sendkeys(String path) {
// TODO Auto-generated method stub
return null;
}

private static void assertThat(String text, Object object) {
// TODO Auto-generated method stub

}

private static Object is(Object equalTo) {
// TODO Auto-generated method stub
return null;
}

private static Object equalTo(String filename) {
// TODO Auto-generated method stub
return null;
}
}