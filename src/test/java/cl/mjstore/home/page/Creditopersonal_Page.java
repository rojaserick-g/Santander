package cl.mjstore.home.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import cl.mjstore.configuracion.TestBase;
import Utils.WaitWebDriver;

public class Creditopersonal_Page extends TestBase {
	public Creditopersonal_Page (WebDriver driver) {
		getDriver();
		PageFactory.initElements(driver, this);
	}
	
	// Define Object Page
	@FindBy(xpath = "//*[@id=\"submenuPersonas\"]/li[4]/a")
	private WebElement btn_menu_credito;
	
	@FindBy(id = "d_rut")
	private WebElement txt_ingreso_rut;
	
	@FindBy(xpath = "//*[@id=\"formulario1\"]/li[2]/input[1]")
	private WebElement  txt_monto_solicitar;
	
	@FindBy(xpath = "//*[@id=\"formulario1\"]/li[3]/select/option[6]")
	private WebElement cmb_numero_cuotas;
	
	@FindBy (xpath = "//*[@id=\"formulario1\"]/li[4]/select/option[1]")
	private WebElement cmb_defase_pago;
	
	@FindBy(xpath = "//*[@id=\"formulario1\"]/li[5]/select[1]/option[1]")
	private WebElement cmb_mes_no_pago1;
	
	@FindBy(xpath = "//*[@id=\"formulario1\"]/li[5]/select[2]/option[1]")
	private WebElement cmb_mes_no_pago2;
	
	@FindBy(id = "btn_preguntas")
	private WebElement btn_simular;
	
	//Frame renta
	@FindBy(xpath = "//*[@id=\"tramo\"]/fieldset/ul/li[2]/select/option[4]")
	private WebElement cmb_renta;
	
	@FindBy(xpath = "//*[@id=\"enviarie\"]/a")
	private WebElement btn_continuar;
	
	public void click_simulador_credito(){
	WaitWebDriver.waitClickable(driver, btn_menu_credito, 5);
	btn_menu_credito.click();
    }
	
	public String Ingreso_Datos_Simula_Credito (String rut, String monto) {
		String msg = "OK";
		if(txt_ingreso_rut.isDisplayed()) {
			txt_ingreso_rut.isSelected();
			txt_ingreso_rut.clear();
			txt_ingreso_rut.sendKeys(rut);
		}
		if(txt_monto_solicitar.isDisplayed()) {
			txt_monto_solicitar.isSelected();
			txt_monto_solicitar.clear();
			txt_monto_solicitar.sendKeys(monto);
		}
		if(cmb_numero_cuotas.isDisplayed()) {
			cmb_numero_cuotas.isSelected();
			cmb_numero_cuotas.click();
		}
		if(cmb_defase_pago.isDisplayed()) {
			cmb_defase_pago.isSelected();
			cmb_defase_pago.click();
		}
		if(cmb_mes_no_pago1.isDisplayed()) {
			cmb_mes_no_pago1.isSelected();
			cmb_mes_no_pago1.click();
		}
		if(cmb_mes_no_pago2.isDisplayed()) {
			cmb_mes_no_pago2.isSelected();
			cmb_mes_no_pago2.click();
		}		
		return msg;	
	}
	
	public void click_btn_simular() {
		WaitWebDriver.waitClickable(driver, btn_simular, 5);
		btn_simular.click();
		
	}
	
	// Selection renta	
	public void click_renta_frame() {
		if(cmb_renta.isDisplayed()) {
			cmb_renta.isSelected();
			cmb_renta.click();
		}
		
	}
	
	public void clic_btn_continuar() throws InterruptedException {
		if(btn_continuar.isDisplayed()) {
			btn_continuar.isSelected();
			btn_continuar.click();
		}
	}

	
	
	
	
	
	
}
