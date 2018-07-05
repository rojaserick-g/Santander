package cl.mjstore.configuracion;
import java.io.File;
import org.testng.annotations.BeforeTest;
import com.relevantcodes.extentreports.ExtentReports; 
import com.relevantcodes.extentreports.ExtentTest; 

public class ExtentReportsManeger {
	ExtentReports extent;
	ExtentTest logger;
	
	@BeforeTest
	private void startTest() {
		extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/SMTExtensReport.html",true);
		
		extent
		.addSystemInfo("Host Name", "Santander-Framework-Selenium")
        .addSystemInfo("Environment", "Automation Testing")
        .addSystemInfo("User Name", "Rodrigo Campos");
		
		extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
	}
}
