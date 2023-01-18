package sample3;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class LoggingDemo {

	@Test 
	void loggingResponse()
	{
		
		given()
		
		.when()
			.get("https://www.google.com/")
		.then()
		// .log().headers()
		//.and() // .and() is used to separate multiple validation but no necessary
		.log().cookies();
//		.log().body()
//		.log().all();
	}
}
