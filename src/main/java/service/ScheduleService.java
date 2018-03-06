package service;

import dao.GenericDao;
import dao.schedule.Schedule;
import dao.schedule.ScheduleSegment;
import dao.schedule.Timepoint;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kiran on 3/5/18.
 */
public class ScheduleService implements Service {

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
}
