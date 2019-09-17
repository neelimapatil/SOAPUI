package getRequest;
import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class POSTData {
	// JSONObject is a class that represents a Simple JSON.
	// We can add Key - Value pairs using the put method
	public static void postDataRequest()
	{
	RestAssured.config=RestAssured.config().sslConfig(SSLConfig.sslConfig().allowAllHostnames());
	JSONObject requestParams = new JSONObject();
	requestParams.put("FirstName", "Neelima"); 
	requestParams.put("LastName", "Patil");
	requestParams.put("email", "npatil@gmail.com");
	requestParams.put("age", "88");
	requestParams.put("companyId", "3");
		
	RequestSpecification request = RestAssured.given();
	request.header("Content-Type", "application/json");
	 
	// Add the Json to the body of the request
	request.body(requestParams.toJSONString());
	 
	// Post the request and check the response
	Response response = request.post("http://localhost:3000/users");
	
	int code1 = response.getStatusCode();
	System.out.println(code1);
	Response resp1=RestAssured.get("http://localhost:3000/users");
	String data1=resp1.asString();
	System.out.println(data1);
	}

}
