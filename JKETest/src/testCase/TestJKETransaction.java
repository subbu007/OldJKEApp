package testCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import reusable.Support;
import reusable.TestBase;


public class TestJKETransaction extends TestBase{
  /*private WebDriver driver;*/


  @Before
  public void setUp() throws Exception {
	  initialize();
     TestJKETLogin.Login();
  }

  @Test
  public void testJKETransaction( ) throws Exception {
	  
	  
    driver.findElement(By.linkText(OR.getProperty("CheckingAccount"))).click();
    driver.findElement(By.cssSelector(OR.getProperty("AccountType"))).click();
    driver.findElement(By.id(OR.getProperty("AccountTypeDropdown"))).click();
    driver.findElement(By.id(OR.getProperty("AllocateDividendPercentage_Button"))).click();
    driver.findElement(By.id(OR.getProperty("Percentage"))).sendKeys("2");
    driver.findElement(By.id(OR.getProperty("Conform_Button"))).click();
    Support.captureScreenShot("SuccessTransaction ", driver);
    driver.findElement(By.id(OR.getProperty("AllocateDividentPercentage"))).click();
    Thread.sleep(2000);
    
     }

  @After
  
  public void Checkpoint( ) throws Exception {
	  TestBase.TearDown();
  
}
}

  