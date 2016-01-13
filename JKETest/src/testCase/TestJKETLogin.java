package testCase;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import reusable.Support;
import reusable.TestBase;



public class TestJKETLogin extends TestBase  {
	   
	
	public static void Login() throws IOException, InterruptedException{
		initialize();
		
       	 driver.get(TestBase.getUrl());
       	 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 String s2=OR.getProperty("userid");
		 System.out.println("Login User id" + s2);
		driver.findElement(By.id(OR.getProperty("userid"))).sendKeys(TestBase.UserId());
	    driver.findElement(By.id(OR.getProperty("password"))).sendKeys(TestBase.Pwd());
	    driver.findElement(By.id(OR.getProperty("login_button"))).click();
	    Thread.sleep(2000);
	    WebElement element= driver.findElement(By.id(OR.getProperty("logout_button")));
	    String LogoutButton=element.getText();
	    Assert.assertEquals("Login Verification", "Logout", LogoutButton);
	    Support.captureScreenShot("LoginModule ", driver);
	  }

}
