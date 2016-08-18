package admi.buildeeji.bin;

/**
 * Created by Admin on 7/31/2016.
 */
public class NormalBuildExpo {
    String companyName;
    String contactPerson;
    int image;
    String summery;
    String featureProjects;
    String presentProjects;
    String previousProjects;
    String phoneNumber;
    String email;

    public NormalBuildExpo(){
        companyName = "";
        contactPerson = "";
        image = 0;
        summery = "";
        featureProjects = "";
        presentProjects = "";
        previousProjects = "";
        phoneNumber ="";
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

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getSummery() {
        return summery;
    }

    public void setSummery(String summery) {
        this.summery = summery;
    }

    public String getFeatureProjects() {
        return featureProjects;
    }

    public void setFeatureProjects(String featureProjects) {
        this.featureProjects = featureProjects;
    }

    public String getPresentProjects() {
        return presentProjects;
    }

    public void setPresentProjects(String presentProjects) {
        this.presentProjects = presentProjects;
    }

    public String getPreviousProjects() {
        return previousProjects;
    }

    public void setPreviousProjects(String previousProjects) {
        this.previousProjects = previousProjects;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
