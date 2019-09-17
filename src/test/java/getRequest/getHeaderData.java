package getRequest;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class getHeaderData {
	
	public static void getHeaderDataRequest()
	{
	// Retrieve the body of the Response
	RequestSpecification request = RestAssured.given();
	Response response = request.post("http://localhost:3000/users");
	ResponseBody body = response.getBody();
	 
	 // To check for sub string presence get the Response body as a String.
	 // Do a String.contains
	 String bodyAsString = body.asString();
	 
	 // convert the body into lower case and then do a comparison to ignore casing.
	// Assert.assertEquals(bodyAsString.toLowerCase().contains("mark"),true,"Res Mark");//needs testng

	String contentType = response.header("Content-Type");
	 System.out.println("Content-Type value: " + contentType);
	 // Reader header of a give name. In this line we will get
	 // Header named Server
	 String serverType =  response.header("Server");
	 System.out.println("Server value: " + serverType);
	// Reader header of a give name. In this line we will get
	 // Header named Content-Encoding
	 String acceptLanguage = response.header("Content-Encoding");
	 System.out.println("Content-Encoding: " + acceptLanguage);
	// Get all the headers. Return value is of type Headers.
	 // Headers class implements Iterable interface, hence we
	 // can apply an advance for loop to go through all Headers
	 // as shown in the code below
	 Headers allHeaders = response.headers();
	 
	 // Iterate over all the Headers
	 for(Header header : allHeaders)
	 {
	 System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
	 }
	}
}
