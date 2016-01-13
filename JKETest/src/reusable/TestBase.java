package reusable;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;



public class TestBase {
	
	public static WebDriver dr=null;
	public static Actions builder=null;
	public static EventFiringWebDriver driver=null;
	public static WebDriverWait wait;
	public static Properties OR=null;
	 
	
	public static void initialize() throws IOException{
	if(driver == null){
		   OR= new Properties();
		   FileInputStream fn =new FileInputStream(System.getProperty("user.dir")+"//src//resources//or.properties");
			OR.load(fn);
			System.out.println("used id"+OR.getProperty("userid"));
	
	if(Browser().equals("Firefox")){
		 dr = new FirefoxDriver();
	}else if(Browser().equals("IE")){
		 dr = new InternetExplorerDriver();
	}
	else if(Browser().equals("Chrome")){
		 dr = new ChromeDriver();
	}
	 driver = new EventFiringWebDriver(dr);
	 builder = new Actions(dr);
	 wait = new WebDriverWait(driver, 30);
	 /*APP_LOGS = Logger.getLogger("devpinoyLogger");*/
	 /*driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);*/
	 
	  
	 
	}
}
	
    public static Properties getproperty(String Filepath) throws IOException{
    	Properties Cp = new Properties();
               InputStream stream = new FileInputStream(new File(System.getProperty("user.dir")+Filepath));
               System.out.println(stream);
        Cp.load(stream);
         return Cp;
    }
    
	private static Properties getConfig() throws IOException {
		
		Properties P = getproperty("//src//resources//config.properties");
		return P;
	}
	

	public static String getUrl() throws IOException {
		// TODO Auto-generated method stub
		String sUrl=getConfig().getProperty("URL");
		System.out.println("Url is"+sUrl);
		return sUrl;
	}


	public static String UserId() throws IOException {
		// TODO Auto-generated method stub
		String sUId=getConfig().getProperty("UserID");
		System.out.println("userid"+sUId);
		return sUId;
	}
	public static CharSequence Pwd() throws IOException {
		// TODO Auto-generated method stub
		String sPwd=getConfig().getProperty("PWD");
		return sPwd;
	}
	
	public static CharSequence Browser() throws IOException {
		// TODO Auto-generated method stub
		String sBrowser=getConfig().getProperty("Browser");
		return sBrowser;
		
	}

	public static void TearDown() throws IOException {
		// TODO Auto-generated method stub
		driver.quit();
	}

	
	
}