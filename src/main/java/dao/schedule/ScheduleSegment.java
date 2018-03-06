package dao.schedule;

/**
 * Created by Kiran on 3/5/18.
 */
public class ScheduleSegment {

    private int segmentNumber;
    private int increment;
    private int occurrences;
    private Timepoint timepoint;

    public ScheduleSegment(int segmentNumber, int increment, int occurances, Timepoint timepoint) {
        this.segmentNumber = segmentNumber;
        this.increment = increment;
        this.occurrences = occurances;
        this.timepoint = timepoint;
    }

    public ScheduleSegment() {

    }

    public int getSegmentNumber() {
        return segmentNumber;
    }

    public void setSegmentNumber(int segmentNumber) {
        this.segmentNumber = segmentNumber;
    }

    public int getIncrement() {
        return increment;
    }

    public void setIncrement(int increment) {
        this.increment = increment;
    }

    public int getOccurrences() {
        return occurrences;
    }

    public void setOccurrences(int occurrences) {
        this.occurrences = occurrences;
    }

    public Timepoint getTimepoint() {
        return timepoint;
    }

    public void setTimepoint(Timepoint timepoint) {
        this.timepoint = timepoint;
    }
}
