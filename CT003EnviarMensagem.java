package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CT003EnviarMensagem {
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
  public void testCT003EnviarMensagem() throws Exception {
    // Acessa a URL
    driver.get(baseUrl + "/web/forms/shared/-/form/122548");
    // Preenche os campos do Formulário
    driver.findElement(By.name("_com_liferay_dynamic_data_mapping_form_web_portlet_DDMFormPortlet_ddm$$WhatIsYourName$eRKbN3tL$0$$en_US")).clear();
    driver.findElement(By.name("_com_liferay_dynamic_data_mapping_form_web_portlet_DDMFormPortlet_ddm$$WhatIsYourName$eRKbN3tL$0$$en_US")).sendKeys("FELICIANO SILVA");
    driver.findElement(By.id("yui_patched_v3_18_1_1_1620825853699_700")).click();
    driver.findElement(By.name("_com_liferay_dynamic_data_mapping_form_web_portlet_DDMFormPortlet_ddm$$WhyDidYouJoinTheTestingArea$mdxs5FoO$0$$en_US")).clear();
    driver.findElement(By.name("_com_liferay_dynamic_data_mapping_form_web_portlet_DDMFormPortlet_ddm$$WhyDidYouJoinTheTestingArea$mdxs5FoO$0$$en_US")).sendKeys("QUALIDADE");
    driver.findElement(By.id("yui_patched_v3_18_1_1_1620825853699_1164")).click();
    driver.findElement(By.xpath("(//input[@value='01/01/2000'])[2]")).clear();
    driver.findElement(By.xpath("(//input[@value='01/01/2000'])[2]")).sendKeys("01/01/2000");
    // Clica no botão Submit
    driver.findElement(By.id("ddm-form-submit")).click();
    // Valida a mensagem de informações enviadas
    assertEquals(driver.findElement(By.cssSelector("p.ddm-form-description")).getText(), "Information sent successfully!");
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
