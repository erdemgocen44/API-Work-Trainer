package get_http_request_method;

import base_url.DummyApiBasUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get08 extends DummyApiBasUrl {

     /*
     Given
            https://jsonplaceholder.typicode.com/todos/2
     When I send a Get Request
     Then the actual data should be as following;
        {
        "userId": 1,
        "id": 2,
        "title": "quis ut nam facilis et officia qui",
        "completed": false
    }
     */

    @Test

    public void get08() {

        spec.pathParams("bir", "todos", "iki", 2);

        //set the expected data /beklenen datayı oluşturun

        Map<String, Object> expectedData = new HashMap<>();

        expectedData.put("userId", 1);

        expectedData.put("id", 2);

        expectedData.put("title", "quis ut nam facilis et officia qui");

        expectedData.put("completed", false);

        //Send the get request and get the response/get requesti yolla ve response yi al

        Response response = given().spec(spec).when().get("/{bir}/{iki}");

        //Validate yani control etmek

        Map<String, Object> actualData = response.as(HashMap.class);

        assertEquals("Beklenen veriler ve karşılaşılan verilen farklı", expectedData.get("userId"), actualData.get("userId"));
        assertEquals("Beklenen veriler ve karşılaşılan verilen farklı", expectedData.get("id"), actualData.get("id"));


    }
}
