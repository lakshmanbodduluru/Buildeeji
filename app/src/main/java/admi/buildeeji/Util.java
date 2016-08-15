package admi.buildeeji;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by Admin on 7/26/2016.
 */
public class Util {
    public static final String LOGIN_STATUS_KEY = "STATUS";
    public static final String LOGIN_STATUS = "LOGGED_IN";
    public static final String SKIP = "skip";
    public static final String EMAIL_SUBJECT = "EMAIL_SUBJECT";
    public static final String EMAIL_MESSAGE = "EMAIL_MESSAGE";
    public static final String LOGIN = "login";
    public static final String RESULT_COMPANY_NAME = "COMPANY_NAME";
    public static final String RESULT_CONTACT_PERSON = "RESULT_CONTACT_PERSON";
    public static final String RESULT_SUMMERY = "RESULT_SUMMERY";
    public static final String RESULT_FEATURE_PROJECTS = "RESULT_FEATURE_PROJECTS";
    public static final String RESULT_PRESENT_PROJECTS = "RESULT_PRESENT_PROJECTS";
    public static final String RESULT_PAST_PROJECTS = "RESULT_PAST_PROJECTS";

    public static void dataInsertionStatus(Long id, Context context) {
        if (id < 0) {
            Toast.makeText(context, "Unsuccessful", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show();
        }
    }


    public static Intent sendEmail(String toMail, Bundle bundle) {
        String subject = bundle.getString(Util.EMAIL_SUBJECT);
        Intent email = new Intent(Intent.ACTION_VIEW);
        email.setType("plain/text");
        email.setData(Uri.parse("lakshman.bodduluru@gmail.com"));
        email.putExtra(Intent.EXTRA_SUBJECT, subject);
        email.setClassName("com.google.android.gm", "com.google.android.gm.ComposeActivityGmail");
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{toMail});
        email.setType("message/rfc822");
        return email;
    }
}
