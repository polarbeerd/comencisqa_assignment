/*
This code only checks for the second case which is;
2- For “The Latest News” list, verify followings;
a. each news has an author
b. each news has an image
*/
package deniz2;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 
public class selenium {
public static void main(String[] args) throws InterruptedException{
System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
WebDriver driver = new ChromeDriver();
driver.manage().window().maximize();
driver.manage().deleteAllCookies();
driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 

String baseUrl = "http://techcrunch.com/";

// launch chrome and direct it to the Base URL
driver.get(baseUrl);

//gets selection only from the articles and searches if there's a class for the existing author, prints passed if okay, prints failed if there's none
List<WebElement> allInputElements = driver.findElements(By.cssSelector("#tc-main-content > div:nth-child(3) > div > div > div > article"));
for(WebElement inputElement : allInputElements) 
{
	if (inputElement.findElement(By.className("river-byline__authors"))!=null){
	    System.out.println("Test Passed!");
	} else {
	    System.out.println("Test Failed");
	}
}

//searches if there's a class for the imported media.
for(WebElement inputElement : allInputElements) 
{
	if (inputElement.findElement(By.className("post-block__media"))!=null){
	    System.out.println("Test Passed!");
	} else {
	    System.out.println("Test Failed");
	}
}



driver.close(); } }