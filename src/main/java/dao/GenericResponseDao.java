package dao;

/**
 * Created by Kiran on 3/5/18.
 */
public class GenericResponseDao {
    private String createdDate;
    private String createdBy;
    private String configurationStatus;

    public GenericResponseDao(String createdDate, String createdBy, String configurationStatus) {
        this.createdDate = createdDate;
        this.createdBy = createdBy;
        this.configurationStatus = configurationStatus;
    }

    public GenericResponseDao() {
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getConfigurationStatus() {
        return configurationStatus;
    }

    public void setConfigurationStatus(String configurationStatus) {
        this.configurationStatus = configurationStatus;
    }
}
