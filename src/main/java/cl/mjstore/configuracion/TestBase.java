package cl.mjstore.configuracion;

import java.util.ResourceBundle;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import Utils.Log;

public class TestBase {
	static ResourceBundle bundle = ResourceBundle.getBundle("datos");
	protected static final String CUR_DIR = System.getProperty("user.dir");
	protected static final String BROWSER = System.getProperty("BROWSER", bundle.getString("Navegador"));
	protected static final String WEB_SERVER = System.getProperty("WEB_SERVER", bundle.getString("url"));
	protected static WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}

	public static void setupDriver(String browserType, String appURL) {
		if (browserType.equals("chrome")) {
			driver = initchromeDriver(appURL);
		} else {
			throw new RuntimeException("Browser no soportado" + browserType);
		}
	}

	private static WebDriver initchromeDriver(String appURL) {
		// data system os run
		String os = System.getProperty("os.name").toLowerCase();
		String user = System.getProperty("user.dir");
		System.out.println("Inicia Navegador :" + BROWSER);
		System.out.println(os);

		if (os.contains("mac")) {
			System.setProperty("webdriver.chrome.driver", "" + user + "/src/main/resources/driver/chromedriver");
		} else {
			System.setProperty("webdriver.chrome.driver",
					"" + user + "\\src\\main\\resources\\driver\\chromedriver.exe");
		}
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		return driver;
	}

	@BeforeClass
	public void initializeTestBaseSetup() {
		Log.endLog("Test is Starting");
		try {
			setupDriver(BROWSER, WEB_SERVER);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error...." + e.getStackTrace());
		}
	}

	@AfterClass
	public void cerrarNavegador() {
	Log.endLog("Test is Ending");
		driver.close();
	}
}
