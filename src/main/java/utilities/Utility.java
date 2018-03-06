package utilities;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import service.Service;

import static com.jayway.restassured.RestAssured.given;
import static utilities.Constant.qaGrToken;

/**
 * Created by Kiran on 3/5/18.
 */
public class Utility {

    public Response postRequest(Environment env, API api, Service service) {
        RestAssured.baseURI = env.getURL(api);
        RequestSpecification request = given();
        request.header("Authorization", qaGrToken);
        request.contentType(env.getContentType());
        request.body(service.getRequestBody());
        Response response = request.post();
        return response;
    }
}
