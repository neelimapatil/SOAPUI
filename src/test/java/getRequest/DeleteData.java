package getRequest;

import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;

public class DeleteData {

	public static void deleteDataRequest()
	{
	 RestAssured.config=RestAssured.config().sslConfig(SSLConfig.sslConfig().allowAllHostnames());
	 RestAssured.delete("http://localhost:3000/users/jUiSHmK");
	}
}
