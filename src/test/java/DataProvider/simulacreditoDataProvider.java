package DataProvider;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import Entities.SimulaCredito;


public class simulacreditoDataProvider {
	@DataProvider
	public Object[][] getData() throws FileNotFoundException {
		      JsonElement jsonData = new JsonParser().parse(new FileReader("src/main/resources/json/simula_credito.json"));
		      JsonElement dataSet = jsonData.getAsJsonObject().get("dataSet");
		      List<SimulaCredito> simulacredito = new Gson().fromJson(dataSet, new TypeToken<List<SimulaCredito>>() {
		      }.getType());
		      Object[][] returnValue = new Object[simulacredito.size()][1];
		      int index = 0;
		      for (Object[] each : returnValue) {
		          each[0] = simulacredito.get(index++);
		      }
		      return returnValue;
		  }
}
