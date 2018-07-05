package cl.mjstore.home.page;

import cl.mjstore.configuracion.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage extends TestBase {
	public HomePage(WebDriver driver) {
		getDriver();
	    PageFactory.initElements(driver, this);
	  }
	
	// Define Objects page

	@FindBy(xpath = "//*[@id=\"d_rut\"]")
	private WebElement txt_ingreso_rut;

	@FindBy(xpath = "//*[@id=\"d_pin\"]")
	private WebElement txt_ingreso_clave;
	
	@FindBy(xpath = "//*[@id=\"botonenvio\"]")
	private WebElement btn_ingresar;
	
	@FindBy(xpath = "/html/body/table/tbody/tr[2]/td[2]/table/tbody/tr[3]/td/table/tbody/tr/td/a")
	private WebElement bton_volver;

	
	
	// constructor
	
/*	public void click_simulador_credito(){
		WaitWebDriver.waitClickable(driver, btn_simulador_credito, 5);
		btn_simulador_credito.click();
	}*/
	
	public String ingresoSesion(String user, String pass) throws InterruptedException{
		String msg = "OK";
		if(txt_ingreso_rut.isDisplayed()) {
			txt_ingreso_rut.isSelected();
			txt_ingreso_rut.clear();
			txt_ingreso_rut.sendKeys(user);
		}	
		if(txt_ingreso_clave.isDisplayed()) {
			txt_ingreso_clave.isSelected();
			txt_ingreso_clave.clear();
			txt_ingreso_clave.sendKeys(pass);
		}
		if(btn_ingresar.isDisplayed()) {
			btn_ingresar.click();
			Thread.sleep(500);
		}
		bton_volver.click(); //ingresa un seundo dato
		
		return msg;
		}
	
	
	
}
