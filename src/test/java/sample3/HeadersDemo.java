package sample3;


import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;


public class HeadersDemo {

	@Test
	void testHeaders() {
		
		given()
		
		.when()
			.get("https://www.google.com/")
		.then()
		.header("Content-Type", "text/html; charset=ISO-8859-1")
		.and() // .and() is used to separate multiple validation but no necessary
		.header("content-encoding", "gzip")
		.header("Server", "gws")
		.log().headers();
	}
	
	@Test
	void getHeadersInfo() {
		
		Response res=given()
		
		.when()
			.get("https://www.google.com/");
		
		// get single header info
//		 String header_value = res.getHeader("Content-Type");
//		 System.out.println("Value of content type is ===>" + header_value);
		
		// get all headers
		Headers myHeaders = res.getHeaders();
		
		// System.out.println(cookies_value.keySet());
		
		for(Header hd: myHeaders) {
			System.out.println(hd.getValue() + "       " +  hd.getValue());
		}
	}
}
