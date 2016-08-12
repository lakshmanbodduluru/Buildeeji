package admi.buildeeji.bin;

/**
 * Created by Admin on 7/19/2016.
 */
public class Notifications {

    String companyName;
    String contactPerson;
    String dateTime;
    String summery;
    String pastProjects;
    String presentProjects;
    String featureProjects;

    public Notifications() {
        companyName = "";
        contactPerson = "";
        dateTime = "";
        summery = "";
        pastProjects = "";
        featureProjects = "";
        presentProjects = "";
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getSummery() {
        return summery;
    }

    public void setSummery(String summery) {
        this.summery = summery;
    }

    public String getPastProjects() {
        return pastProjects;
    }

    public void setPastProjects(String pastProjects) {
        this.pastProjects = pastProjects;
    }

    public String getPresentProjects() {
        return presentProjects;
    }

    public void setPresentProjects(String presentProjects) {
        this.presentProjects = presentProjects;
    }

    public String getFeatureProjects() {
        return featureProjects;
    }

    public void setFeatureProjects(String featureProjects) {
        this.featureProjects = featureProjects;
    }
}
