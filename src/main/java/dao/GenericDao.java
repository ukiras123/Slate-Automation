package dao;

/**
 * Created by Kiran on 3/5/18.
 */
public class GenericDao {
    private String activationDate;
    private String inactivationDate;
    private String workflow;

    public GenericDao() {
    }

    public GenericDao(String activationDate, String inactivationDate, String workflow) {
        this.activationDate = activationDate;
        this.inactivationDate = inactivationDate;
        this.workflow = workflow;
    }

    public String getActivationDate() {
        return activationDate;
    }

    public void setActivationDate(String activationDate) {
        this.activationDate = activationDate;
    }

    public String getInactivationDate() {
        return inactivationDate;
    }

    public void setInactivationDate(String inactivationDate) {
        this.inactivationDate = inactivationDate;
    }

    public String getWorkflow() {
        return workflow;
    }

    public void setWorkflow(String workflow) {
        this.workflow = workflow;
    }
}
