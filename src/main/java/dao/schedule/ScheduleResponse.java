package dao.schedule;

import dao.GenericResponseDao;

/**
 * Created by Kiran on 3/5/18.
 */
public class ScheduleResponse extends GenericResponseDao {
    private String scheduleCode;

    public ScheduleResponse(String createdDate, String createdBy, String configurationStatus, String scheduleCode) {
        super(createdDate, createdBy, configurationStatus);
        this.scheduleCode = scheduleCode;
    }

    public ScheduleResponse() {
    }

    public String getScheduleCode() {
        return scheduleCode;
    }

    public void setScheduleCode(String scheduleCode) {
        this.scheduleCode = scheduleCode;
    }
}
