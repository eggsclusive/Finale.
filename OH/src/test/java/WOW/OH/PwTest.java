package WOW.OH;

//Yonatan Mattar - 315957571
//Riad Zoabi - 211830369

import static org.junit.Assert.assertEquals;
import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PwTest {

  private static WebDriver browser;

  @Before public void setup() {
  	System.setProperty("webdriver.gecko.driver", "C:\\Users\\onich\\OneDrive\\Desktop\\geckodriver.exe");
      browser = new FirefoxDriver();
      browser.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
      browser.get("https://testpages.eviltester.com/styled/apps/7charval/simple7charvalidation.html");
      }

  @Test public void testValidInputWithSevenCharacters() {
      WebElement textBox = browser.findElement(By.name("characters"));
      textBox.sendKeys("2345678");
      browser.findElement(By.name("validate")).click();
      WebElement resultElement = browser.findElement(By.name("validation_message"));
      String actualResult = resultElement.getAttribute("value");
      String expectedResult = "Valid Value";
      assertEquals(expectedResult, actualResult);
      System.out.println("Test 1: " + actualResult);
      }
  @Test public void testEmptyInput() {
      WebElement textBox = browser.findElement(By.name("characters"));
      textBox.sendKeys("");
      browser.findElement(By.name("validate")).click();
      WebElement resultElement = browser.findElement(By.name("validation_message"));
      String actualResult = resultElement.getAttribute("value");
      String expectedResult = "Invalid Value";
      assertEquals(expectedResult, actualResult);
      System.out.println("Test 2: " + actualResult);
      }
  @Test public void testValidInputWithAlphanumericCharacters() {
      WebElement textBox = browser.findElement(By.name("characters"));
      textBox.sendKeys("Ab3C5dE");
      browser.findElement(By.name("validate")).click();
      WebElement resultElement = browser.findElement(By.name("validation_message"));
      String actualResult = resultElement.getAttribute("value");
      String expectedResult = "Valid Value";
      assertEquals(expectedResult, actualResult);
      System.out.println("Test 3: " + actualResult);
      }
  @Test public void testInvalidInputWithSpecialCharacters() {
  	WebElement textBox = browser.findElement(By.name("characters"));
      textBox.sendKeys("2!1dCbAa");
      browser.findElement(By.name("validate")).click();
      WebElement resultElement = browser.findElement(By.name("validation_message"));
      String actualResult = resultElement.getAttribute("value");
      String expectedResult = "Invalid Value";
      assertEquals(expectedResult, actualResult);
      System.out.println("Test 4: " + actualResult);
      }
}