package get_http_request_method;

import base_urls.DummyApiBasUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

public class Get07 extends DummyApiBasUrl {

     /*
        Given
             http://dummy.restapiexample.com/api/v1/employee/7
        When
            I send a GET request to the Url
        Then
            HTTP Status Code should be 200
        And
            Response format should be "application/json"
        And
            Herrod Chandler should be the employee name
        And
            "employee_salary":137500 should be expected salary
        And
           "id":7 should be expected id
     */

    @Test

    public void get07() {
        spec.pathParams("bir", "api", "iki", "v1", "uc", "employee", "son", 7);

        Response response = given().spec(spec).when().get("/{bir}/{iki}/{uc}/{son}");

        response.prettyPrint();

        //1.Validation kısmı

        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)

                .body("data.employee_salary\":137500", equalTo("Herrod Chandler"))
                .body("data.employee_salary", equalTo(137500))
                .body("data.employee.id", equalTo(7));

        //2.validation

        JsonPath json = response.jsonPath();

        System.out.println(json.getString("data.employee_name"));
        System.out.println(json.getInt("data.employee_salary"));


        //Hard assertion =>Scenario çalışır ve ilk hata da execution durur.
        //Soft assertion=>Tüm scenarioları çalıştır ve en son bütün hataları ortaya çıkarır
        assertEquals(json.getString("data.employee_name"), "Herrod Chandler");
        assertEquals(json.getInt("data.employee_salary"), 137500);
        assertEquals(json.getInt("data.employee_id"), 7);

//Soft Assertion

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(json.getString("data.employee_name"), "Herrod Chandler");
        softAssert.assertEquals(json.getInt("data.employee_salary"), 137500);
        softAssert.assertEquals(json.getInt("data.employee_id"), 7);

    }
}
