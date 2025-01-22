package WOW.OH;

//Yonatan Mattar - 315957571
//Riad Zoabi - 211830369

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;

public class TriangleTest {

  private static WebDriver browser;

  @Before public void setup() {
  	System.setProperty("webdriver.gecko.driver", "C:\\Users\\onich\\OneDrive\\Desktop\\geckodriver.exe");
      browser = new FirefoxDriver();
      browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      browser.get("https://testpages.eviltester.com/styled/apps/triangle/triangle001.html");
      }
  
  @Test public void testEquilateralTriangle() {
      browser.findElement(By.id("side1")).sendKeys("5");
      browser.findElement(By.id("side2")).sendKeys("5");
      browser.findElement(By.id("side3")).sendKeys("5");
      browser.findElement(By.id("identify-triangle-action")).click();
      WebElement resultElement = browser.findElement(By.id("triangle-type"));
      String actualResult = resultElement.getText();
      String expectedResult = "Equilateral";
      assertEquals(expectedResult, actualResult);
      System.out.println("Equilateral Triangle Test: " + actualResult);
      }
  @Test public void testInvalidTriangle() {
      browser.findElement(By.id("side1")).sendKeys("5");
      browser.findElement(By.id("side2")).sendKeys("10");
      browser.findElement(By.id("side3")).sendKeys("5");
      browser.findElement(By.id("identify-triangle-action")).click();
      WebElement resultElement = browser.findElement(By.id("triangle-type"));
      String actualResult = resultElement.getText();
      String expectedResult = "Error: Not a Triangle";
      assertEquals(expectedResult, actualResult);
      System.out.println("Invalid Triangle Test: " + actualResult);
      }
  @Test public void testIsoscelesTriangle() {
      browser.findElement(By.id("side1")).sendKeys("6");
      browser.findElement(By.id("side2")).sendKeys("6");
      browser.findElement(By.id("side3")).sendKeys("3");
      browser.findElement(By.id("identify-triangle-action")).click();
      WebElement resultElement = browser.findElement(By.id("triangle-type"));
      String actualResult = resultElement.getText();
      String expectedResult = "Isosceles";
      assertEquals(expectedResult, actualResult);
      System.out.println("Isosceles Triangle Test: " + actualResult);
      }
  @Test public void testScaleneTriangle() {
      browser.findElement(By.id("side1")).sendKeys("3");
      browser.findElement(By.id("side2")).sendKeys("5");
      browser.findElement(By.id("side3")).sendKeys("7");
      browser.findElement(By.id("identify-triangle-action")).click();
      WebElement resultElement = browser.findElement(By.id("triangle-type"));
      String actualResult = resultElement.getText();
      String expectedResult = "Scalene";
      assertEquals(expectedResult, actualResult);
      System.out.println("Scalene Triangle Test: " + actualResult);
      }
}