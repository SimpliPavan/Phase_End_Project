package goRest;
import java.util.HashMap;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
public class CreateUser {
	public static HashMap<String, String> map = new HashMap<String, String>();
	@BeforeMethod
	public void CreatePostData() {
		map.put("name","Anand");
		map.put("email", "Anand077@gmail.com");
		map.put("gender", "male");
		map.put("status", "active");
		RestAssured.baseURI = "https://gorest.co.in";
		RestAssured.basePath = "/public/v2/users";
	}
	@Test
	public void postData() {
		RestAssured
		.given().contentType("application/json").body(map)
		 	.header("Authorization", "Bearer e0da5b03e46ed072323b44a3e7f904d84803be9bf6074a6489c9d764437f968d")
		 .when().post()
		 .then().statusCode(201).log().all();	
	}
}
