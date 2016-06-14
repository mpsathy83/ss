package seleniumgrid1;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParallelTestB {

public static RemoteWebDriver driver;
public static String appURL = "http://www.google.com";

@BeforeClass
@Parameters({ "browser" })
public void setUp(String browser) throws MalformedURLException {
System.out.println("*******************");
driver = Browser.getDriver(browser);
driver.manage().window().maximize();
}

@Test
public void testGooglePageTitleInChrome() throws InterruptedException {
/*driver.navigate().to("http://www.google.com");
String strPageTitle = driver.getTitle();
Assert.assertTrue(strPageTitle.equalsIgnoreCase("Google"), "Page title doesn't match");*/
	
driver.get("http://www.rediff.com");
driver.findElement(By.xpath("//*[@id='signin_info']/a[1]")).click();
driver.findElement(By.id("login1")).sendKeys("bangtest321@rediffmail.com");
driver.findElement(By.id("password")).sendKeys("abcd@1234");
driver.findElement(By.xpath("//div[1]/input")).click();
Thread.sleep(20000);
String Username=driver.findElement(By.xpath("//span/cite/a")).getText();
System.out.println(Username);
if(Username.equalsIgnoreCase("Kumar")){
System.out.println("Passed");

}
else{
System.out.println("Failed");
}


}

/*@Test
public void testSearchGoogle() {
System.out.println("Opening Google..");
driver.navigate().to(appURL);
driver.findElement(By.name("q")).sendKeys("Selenium Easy Grid Tutorials");
driver.findElement(By.name("btnG")).click();
}*/

@AfterClass
public void tearDown() {
if (driver != null) {
System.out.println("Closing browser");
driver.close();
}
}

}