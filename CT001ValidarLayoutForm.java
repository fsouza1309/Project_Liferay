package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CT001ValidarLayoutForm {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://forms.liferay.com/web/forms/shared/-/form/122548";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testCT001ValidarLayoutForm() throws Exception {
    // Acessa a URL
    driver.get(baseUrl + "/web/forms/shared/-/form/122548");
    // Valida o Layout do Form
    assertEquals(driver.findElement(By.cssSelector("h1.ddm-form-name")).getText(), "This is a Liferay Forms");
    assertTrue(isElementPresent(By.cssSelector("h2.lfr-ddm-form-page-title")));
    assertTrue(isElementPresent(By.xpath("(//input[@value=''])[4]")));
    assertTrue(isElementPresent(By.xpath("(//input[@value=''])[4]")));
    assertTrue(isElementPresent(By.id("ddm-form-submit")));
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
