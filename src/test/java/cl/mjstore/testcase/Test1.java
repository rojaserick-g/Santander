package cl.mjstore.testcase;

import org.testng.annotations.Test;
import cl.mjstore.configuracion.TestBase;
import cl.mjstore.home.page.HomePage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import DataProvider.santanderDataprovider;
import Entities.User;
import Utils.Log;


public class Test1 extends TestBase {
	ExtentReports report = new ExtentReports("src/../reports/Report1.html", true);
	ExtentTest test = report.startTest("Prueba de borde Login");

	
	@Test(dataProvider = "getData", dataProviderClass = santanderDataprovider.class)
	public void simulador_de_creditos(User data) throws InterruptedException {
		
		//Log name method
		Log.info("test is starting");
		HomePage homePage = new HomePage(driver);
		
		//Log click button simulator credit
		Log.info("click simulator credit");
		homePage.ingresoSesion(data.getUsername(), data.getPassword());
		
		//Log click view more
		Log.info("click simulator credit view more");
	//	OneTwoThreeClickPage oneTwoThreeClickPage = homePage.click_simulador_credito_ver_mas();
		
		//Log click view more
		Log.info("valid title page");
	//	Assert.assertTrue(oneTwoThreeClickPage.valida_sub_titulo(), "No se ha encontrado sub titulo de pagina");
		
		//report.endTest(test);
		report.flush();
		test.log(LogStatus.PASS, "Prueba correcta");
		report.endTest(test);
	}
	
	
	
	}
