package admi.buildeeji.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import admi.buildeeji.R;

public class ForgetActivity extends AppCompatActivity implements View.OnClickListener {
    EditText email;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);
        init();
    }

    private void init() {
        initViews();
        initListener();
    }

    private void initListener() {
        submit.setOnClickListener(this);
    }

    private void initViews() {
        email = (EditText) findViewById(R.id.forgot_email);
        submit = (Button) findViewById(R.id.forgot_submit_btn);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.forgot_submit_btn:
                Toast.makeText(ForgetActivity.this, "Link send to your Email", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
