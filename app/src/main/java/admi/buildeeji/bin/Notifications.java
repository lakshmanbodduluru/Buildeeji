package admi.buildeeji.bin;

/**
 * Created by Admin on 7/19/2016.
 */
public class Notifications {

    String companyName;
    String contactPerson;
    String dateTime;

    public Notifications() {
        companyName = "";
        contactPerson = "";
        dateTime = "";
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
}
