package dao.schedule;

/**
 * Created by Kiran on 3/5/18.
 */
public class Timepoint {

    private String form;
    private String days;
    private String ordinals;
    private String months;

    public Timepoint(String form, String days, String ordinals, String months) {
        this.form = form;
        this.days = days;
        this.ordinals = ordinals;
        this.months = months;
    }

    public Timepoint() {
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getOrdinals() {
        return ordinals;
    }

    public void setOrdinals(String ordinals) {
        this.ordinals = ordinals;
    }

    public String getMonths() {
        return months;
    }

    public void setMonths(String months) {
        this.months = months;
    }
}
