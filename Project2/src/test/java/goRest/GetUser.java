package goRest;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static org.hamcrest.Matchers.*;

public class GetUser {

	@Test
	public void getUser() {
		RestAssured
		.given()
		 	.contentType("application/json")
		 	.header("Authorization", "Bearer e0da5b03e46ed072323b44a3e7f904d84803be9bf6074a6489c9d764437f968d")
		 .when()
		 	.get("https://gorest.co.in/public/v2/users/5867")
		 .then()
		 	.statusCode(200)
			.log().all()
			.and()
		 	.body("email", is("Anand077@gmail.com")); 	
	}
}
