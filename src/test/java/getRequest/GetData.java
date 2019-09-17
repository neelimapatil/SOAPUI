package getRequest;

import org.apache.http.HttpStatus;
import org.junit.Assert;

import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.response.Response;

public class GetData {

	public static void getDataRequest() 
	{
		RestAssured.config=RestAssured.config().sslConfig(SSLConfig.sslConfig().allowAllHostnames());
//		Response resp=RestAssured.get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
		//Response resp=RestAssured.get("https://www.nseindia.com/homepage/Indices1.json");
		Response resp=RestAssured.get("http://localhost:3000/users");
	    int code = resp.getStatusCode();
	    System.out.println(code);
	    Assert.assertEquals(code, HttpStatus.SC_OK);//200 code
	    String data=resp.asString();
	    System.out.println(data);
	    System.out.println("1st changes");
	}
}
