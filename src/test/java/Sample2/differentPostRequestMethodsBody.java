package Sample2;



import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;


public class differentPostRequestMethodsBody {
	
	// Post request body using HashMap
	// @Test
	void testPostUsingHashMap()
	{
		HashMap data=new HashMap();
		
		data.put("name", "Sammy");
		data.put("location", "New York");
		data.put("phone", "12421");
		
		String courseArr[] = { "C", "Python"};
		data.put("courses", courseArr);
		
		
		given()
			.contentType("application/json")
			.body(data)
			
		.when()
			.post("http://localhost:3000/students")
		
		.then()
			.statusCode(201)
			.body("name", equalTo("Sammy"))
			.body("location", equalTo("New York"))
			.body("phone", equalTo("12421"))
			.body("courses[0]", equalTo("V"))
			.body("courses[1]", equalTo("Python"))
			.header("Content-Type", "application/json; charset=utf-8")
			.log().all();
	}
	
	//2) Post request body using org.json
		// @Test(priority=1)
		void testPostUsingJsonLibrary()
		{
			JSONObject data=new JSONObject();
			
			data.put("name", "Sammy");
			data.put("location", "New York");
			data.put("phone", "12421");
			
			String courseArr[] = { "C", "Python"};
			data.put("courses", courseArr);
			
			
			given()
				.contentType("application/json")
				.body(data.toString())
				
			.when()
				.post("http://localhost:3000/students")
			
			.then()
				.statusCode(201)
				.body("name", equalTo("Sammy"))
				.body("location", equalTo("New York"))
				.body("phone", equalTo("12421"))
				.body("courses[0]", equalTo("V"))
				.body("courses[1]", equalTo("Python"))
				.header("Content-Type", "application/json; charset=utf-8")
				.log().all();
		}
		
		//3) Post request body using org.json
				// @Test(priority=1)
				void testPostUsingPOJO()
				{
					Pojo_PostRequest data=new Pojo_PostRequest();
					
					data.setName("Sammy");
					data.setLocation("New York");
					data.setPhone("12421");
					
					String courseArr[] = { "C", "Python"};
					data.setCourses(courseArr);
					
					
					given()
						.contentType("application/json")
						.body(data)
						
					.when()
						.post("http://localhost:3000/students")
					
					.then()
						.statusCode(201)
						.body("name", equalTo("Sammy"))
						.body("location", equalTo("New York"))
						.body("phone", equalTo("12421"))
						.body("courses[0]", equalTo("V"))
						.body("courses[1]", equalTo("Python"))
						.header("Content-Type", "application/json; charset=utf-8")
						.log().all();
				}


				//3) Post request body using org.json
				// @Test(priority=1)
				void testPostUsingExternalJsonFile() throws FileNotFoundException
				{
					File f=new File(".\\body.json");
					
					FileReader fr=new FileReader(f);
					
					JSONTokener jt=new JSONTokener(fr);
					
					JSONObject data=new JSONObject(jt);
					
					
					given()
						.contentType("application/json")
						.body(data.toString())
						
					.when()
						.post("http://localhost:3000/students")
					
					.then()
						.statusCode(201)
						.body("name", equalTo("Sammy"))
						.body("location", equalTo("New York"))
						.body("phone", equalTo("12421"))
						.body("courses[0]", equalTo("V"))
						.body("courses[1]", equalTo("Python"))
						.header("Content-Type", "application/json; charset=utf-8")
						.log().all();
				}
	
	//deleting student record
	@Test(priority=2)
	void testDelete()
	{
		given()
		
		.when()
			.delete("http://localhost:3000/students/4")
		
		.then()
			.statusCode(200)
			.log().all();
	}

}
