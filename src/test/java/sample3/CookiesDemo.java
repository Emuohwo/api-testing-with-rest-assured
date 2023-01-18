package sample3;


import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

public class CookiesDemo {

	@Test
	void testCookies() {
		
		given()
		
		.when()
			.get("https://www.google.com/")
		.then()
//		It should fail as expected
		.cookie("AEC", "ARSKqsL9ArbvvR6m2tQjnAbPtFLPR1DFHc5TsJZBC5DNxJZuYz4NP2ySH-Y")
			.log().all();
	}
	
	@Test
	void getCookiesInfo() {
		
		Response res=given()
		
		.when()
			.get("https://www.google.com/");
		
		// get single cookie info
		// String cookie_value = res.getCookie("AEC");
		// System.out.println("Value of cookie is ===>" + cookie_value);
		
		// get all cookies
		Map<String, String> cookies_value = res.getCookies();
		
		// System.out.println(cookies_value.keySet());
		
		for(String k: cookies_value.keySet()) {
			String cookie_value = res.getCookie(k);
			System.out.println(k + "   " +  cookie_value);
		}
	}
}
