package main;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ResponseBody;
import com.jayway.restassured.specification.RequestSpecification;
import dao.schedule.ScheduleResponse;
import service.ScheduleService;
import service.Service;
import utilities.API;
import utilities.Environment;

import static com.jayway.restassured.RestAssured.given;
import static utilities.Constant.qaGrToken;

/**
 * Created by Kiran on 3/5/18.
 */
public class Main {

    public static void main(String[] args) {
        Environment env = new Environment("QA");
        Service service = new ScheduleService();
        RestAssured.baseURI = env.getURL(API.SCHEDULE);
        RequestSpecification request = given();
        request.header("Authorization", qaGrToken);
        request.contentType(env.getContentType());
        request.body(service.getRequestBody());
        Response response = request.post();
        ResponseBody body = response.getBody();
        ScheduleResponse scheduleResponse = body.as(ScheduleResponse.class);
        System.out.println("Status: "+response.getStatusCode());
        System.out.println("Body: "+body.asString());
        System.out.println("Schedule Code: " + scheduleResponse.getScheduleCode());
    }
}
