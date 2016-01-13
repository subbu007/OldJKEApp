package reusable;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;




public class Support {
	
	
	public static void captureScreenShot(String obj, WebDriver driver) throws IOException {
        File screenshotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile,new File("Screenshots\\"+obj+""+GetTimeStampValue()+".png"));
        
  }

  public static  String GetTimeStampValue()throws IOException{

          Calendar cal = Calendar.getInstance();       
           Date time=cal.getTime();
           String timestamp=time.toString();
              System.out.println(timestamp);
              String systime=timestamp.replace(":", "-");
              System.out.println(systime);
          return systime;

  }

}
