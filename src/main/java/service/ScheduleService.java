package service;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ResponseBody;
import com.jayway.restassured.specification.RequestSpecification;
import dao.GenericDao;
import dao.schedule.Schedule;
import dao.schedule.ScheduleResponse;
import dao.schedule.ScheduleSegment;
import dao.schedule.Timepoint;
import utilities.API;
import utilities.Environment;

import java.util.ArrayList;
import java.util.List;

import static com.jayway.restassured.RestAssured.given;
import static utilities.Constant.qaGrToken;

/**
 * Created by Kiran on 3/5/18.
 */
public class ScheduleService extends Service {

    public GenericDao getRequestBody() {
        Timepoint timepoint = new Timepoint();
        timepoint.setForm("DAY_INTERVAL");

        ScheduleSegment s1 = new ScheduleSegment();
        s1.setSegmentNumber(1);
        s1.setIncrement(30);
        s1.setOccurrences(1);
        s1.setTimepoint(timepoint);

        List<ScheduleSegment> segments = new ArrayList<ScheduleSegment>();
        segments.add(s1);

        Schedule schedule = new Schedule();
        schedule.setScheduleSegments(segments);
        schedule.setDescription("30 day repeat - Automation");
        schedule.setActivationDate("2017-06-27T17:25:09-04:00");
        schedule.setInactivationDate("2020-10-28T23:59:59-04:00");
        schedule.setRepeatLastSegmentIndefinitely(true);
        schedule.setWorkflow("push");
        schedule.setFirstOccurrenceOverride("IMMEDIATELY");
        return schedule;
    }

    public static String createSchedule(String givenEnv, Schedule schedule) {
        try {
            Environment env = new Environment(givenEnv);
            RestAssured.baseURI = env.getURL(API.SCHEDULE);
            RequestSpecification request = given();
            request.header("Authorization", qaGrToken);
            request.contentType(env.getContentType());
            request.body(schedule);
            Response response = request.post();
            ResponseBody body = response.getBody();
            if (response.getStatusCode() == 201) {
                ScheduleResponse scheduleResponse = body.as(ScheduleResponse.class);
                return scheduleResponse.getScheduleCode();
            } else {
                throw new Exception(body.asString());
            }
        } catch (Exception e) {
            System.out.println("Exception occurred during schedule create: "+e.getMessage());
            return "Error During Creation: "+e.getMessage();
        }
    }
}
