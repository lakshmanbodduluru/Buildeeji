package admi.buildeeji.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import admi.buildeeji.R;

public class ContactUs extends AppCompatActivity implements AdapterView.OnItemClickListener {
    Spinner mReason;
    Spinner mCountry;
    EditText mMobile;
    EditText mEmail;
    EditText mDescription;
    Button mSendButton;
    ArrayAdapter<CharSequence> reasonAdapter;
    ArrayAdapter<CharSequence> countryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        init();
    }

    private void init() {
        initViews();
        initListener();
    }

    private void initListener() {
//        reason.setOnItemClickListener(this);
    }

    private void initViews() {
        mReason = (Spinner) findViewById(R.id.contact_us_reason_spinner);
        mCountry = (Spinner) findViewById(R.id.contact_us_country_code_spinner);
        mMobile = (EditText) findViewById(R.id.contact_us_mobile_et);
        mEmail = (EditText) findViewById(R.id.contact_us_email_et);
        mDescription = (EditText) findViewById(R.id.contact_us_description_et);
        mSendButton = (Button) findViewById(R.id.contact_us_send);
        reasonAdapter = ArrayAdapter.createFromResource(this, R.array.contact_us_reason, R.layout.custome_spinner);
        countryAdapter = ArrayAdapter.createFromResource(this, R.array.contact_us_country_code, R.layout.custome_spinner);
        mReason.setAdapter(reasonAdapter);
        mCountry.setAdapter(countryAdapter);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (view.getId()) {
            case R.id.contact_us_reason_spinner:
                break;
            case R.id.contact_us_country_code_spinner:
                break;
        }
    }
}
