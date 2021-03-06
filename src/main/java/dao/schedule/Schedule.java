package dao.schedule;

import dao.GenericDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kiran on 3/5/18.
 */
public class Schedule extends GenericDao {

    private String description;
    private boolean repeatLastSegmentIndefinitely;
    private String firstOccurrenceOverride;

    private List<ScheduleSegment> scheduleSegments;

    public Schedule() {
        scheduleSegments = new ArrayList<ScheduleSegment>();
        this.setActivationDate("2017-06-27T17:25:09-04:00");
        this.setInactivationDate("2020-10-28T23:59:59-04:00");
        this.setWorkflow("push");
    }

    public Schedule(String activationDate, String inactivationDate, String workflow, String description, boolean repeatLastSegmentIndefinitely, String firstOccurrenceOverride, List<ScheduleSegment> scheduleSegments) {
        super(activationDate, inactivationDate, workflow);
        this.description = description;
        this.repeatLastSegmentIndefinitely = repeatLastSegmentIndefinitely;
        this.firstOccurrenceOverride = firstOccurrenceOverride;
        this.scheduleSegments = scheduleSegments;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isRepeatLastSegmentIndefinitely() {
        return repeatLastSegmentIndefinitely;
    }

    public void setRepeatLastSegmentIndefinitely(boolean repeatLastSegmentIndefinitely) {
        this.repeatLastSegmentIndefinitely = repeatLastSegmentIndefinitely;
    }

    public String getFirstOccurrenceOverride() {
        return firstOccurrenceOverride;
    }

    public void setFirstOccurrenceOverride(String firstOccurrenceOverride) {
        this.firstOccurrenceOverride = firstOccurrenceOverride;
    }

    public List<ScheduleSegment> getScheduleSegments() {
        return scheduleSegments;
    }

    public void setScheduleSegments(List<ScheduleSegment> scheduleSegments) {
        this.scheduleSegments = scheduleSegments;
    }
}
