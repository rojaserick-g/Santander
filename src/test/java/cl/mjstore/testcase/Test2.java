package cl.mjstore.testcase;

import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import DataProvider.simulacreditoDataProvider;
import Entities.SimulaCredito;
import Utils.Log;
import cl.mjstore.configuracion.TestBase;
import cl.mjstore.home.page.Creditopersonal_Page;


public class Test2 extends TestBase {
	ExtentReports report = new ExtentReports("src/../reports/Report1.html", true);
	ExtentTest test = report.startTest("Prueba Simular credito");
	
	@Test(dataProvider = "getData", dataProviderClass = simulacreditoDataProvider.class)
	public void simulador_de_creditos(SimulaCredito data) throws InterruptedException {
		
		//Log name method
		Log.info("test is starting");
		Creditopersonal_Page simulacredito = new Creditopersonal_Page(driver);
		
		//Log click button simulator credit
		Log.info("click simulator credit");
		simulacredito.click_simulador_credito();
		
		Log.info("Ingreso de datos al formulario");
		simulacredito.Ingreso_Datos_Simula_Credito(data.getRut(), data.getMontocredito());
		
		
		Log.info("clic btn simular credito");
		simulacredito.click_btn_simular();
		
		Log.info("selecciona renta ");
		simulacredito.click_renta_frame();
		Log.info("clic btn continuar");
		simulacredito.clic_btn_continuar();
		
		//report.endTest(test);
		report.flush();
		test.log(LogStatus.PASS, "Prueba correcta simulator credit");
		report.endTest(test);
	}
	
}
