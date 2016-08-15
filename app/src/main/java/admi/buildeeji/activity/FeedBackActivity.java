package admi.buildeeji.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

import admi.buildeeji.BuildeejiActivity;
import admi.buildeeji.R;

public class FeedBackActivity extends BuildeejiActivity implements View.OnClickListener {
    ActionBar mActionBar;
    LinearLayout tollFreeNumber;
    Spinner reason;
    ArrayAdapter<CharSequence> reasonAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back);
        init();
        mActionBar = getSupportActionBar();
        mActionBar.setTitle("FeedBack");
    }

    private void init() {
        initViews();
        initListener();
    }

    private void initListener() {
        tollFreeNumber.setOnClickListener(this);
    }

    private void initViews() {
        tollFreeNumber = (LinearLayout) findViewById(R.id.toolfree_number_linear);
        reason = (Spinner) findViewById(R.id.feedback_reason_spinner);
        reasonAdapter = ArrayAdapter.createFromResource(this, R.array.contact_us_reason, R.layout.custome_spinner);
        reason.setAdapter(reasonAdapter);
        tollFreeNumber.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.toolfree_number_linear:
                String phone = "9494896482";
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + phone));
                startActivity(intent);
                break;
            case R.id.feedback_send_btn:
                break;
        }
    }
}
