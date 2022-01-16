package post_http_request_method;

import base_urls.HerokuappBaseUrl;
import org.junit.Test;

public class Post01 extends HerokuappBaseUrl {
/*
        When
            I send POST Request to the Url https://restful-booker.herokuapp.com/booking
            with the request body {
                                    "firstname": "Erdem",
                                    "lastname": "Gocen",
                                    "totalprice": 11111,
                                    "depositpaid": true,
                                    "bookingdates": {
                                        "checkin": "2022-09-09",
                                        "checkout": "2022-09-21"
                                     }
                                  }
        Then
            Status code is 200
            And response body should be like {
                                                "bookingid": 11,
                                                "booking": {
                                                    "firstname": "Erdem",
                                                    "lastname": "Gocen",
                                                    "totalprice": 11111,
                                                    "depositpaid": true,
                                                    "bookingdates": {
                                                        "checkin": "2022-09-09",
                                                        "checkout": "2022-09-21"
                                                    }
                                                }
                                             }
     */

    @Test

    public void post01() {

        //set the url
        spec.pathParam("bir", "booking");
    }
}
