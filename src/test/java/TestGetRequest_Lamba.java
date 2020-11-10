import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.bson.json.JsonWriterSettings;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestGetRequest_Lamba {
	
	@Test
	public void invokePostRequest() {
		
		//Specify Base URI 
		RestAssured.baseURI = "";
		RequestSpecification request = RestAssured.given();
		
      
		org.json.simple.JSONObject requestParams = new org.json.simple.JSONObject();
		requestParams.put("key1", "value1");
	//	request.header("Content-Type","application/json");
		request.body(requestParams.toJSONString());
		
		Response response = request.request(Method.POST,"/");
		String respBody = response.body().asString();
		System.out.println(respBody);
		
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		
		Assert.assertEquals(true, false,"testdata");
	}
	

}
