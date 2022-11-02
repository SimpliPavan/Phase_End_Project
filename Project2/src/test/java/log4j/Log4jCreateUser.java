package log4j;
import java.util.HashMap;
import java.util.UUID;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
public class Log4jCreateUser extends BaseTest{
	public static HashMap<String, String> map = new HashMap<String, String>();
	UUID uuid = UUID.randomUUID();
	String id;
	@Test (priority = 0)
	public void CreatePostData() {
		map.put("name","Anand");
		logger.info("Added Name");
		map.put("email", "Anand"+ uuid +"@gmail.com");
		logger.info("Added Email");
		map.put("gender", "male");
		logger.info("Added gender");
		map.put("status", "active");
		logger.info("Added status");
		RestAssured.baseURI = "https://gorest.co.in";
		RestAssured.basePath = "/public/v2/users";
		logger.info("Payload created for creating the resource");
	}
	
	
	@Test (priority = 1)
	
	public void CreateUser() {
	Response response = RestAssured
						.given()
						.contentType("Application/json")
						.body(map)
						.header("Authorization", "Bearer e0da5b03e46ed072323b44a3e7f904d84803be9bf6074a6489c9d764437f968d")
						.when()
							.post()
						.then()
							.log().all()
						.contentType(ContentType.JSON).extract().response();
	
	logger.info("Resourse created and response captured");
	JsonPath jsonPath = response.jsonPath();
	logger.info("Jsonpath created");
	id = jsonPath.get("id").toString();
	logger.info("Resourse id captured");						
	}
}

