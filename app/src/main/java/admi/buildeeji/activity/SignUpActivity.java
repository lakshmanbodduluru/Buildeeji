package admi.buildeeji.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import admi.buildeeji.R;
import admi.buildeeji.bin.Registration;
import admi.buildeeji.database.MyDatabase;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {
    EditText mUserName;
    EditText mEmail;
    EditText mMobile;
    EditText mPassword;
    EditText mConformPassword;
    TextView mTvSignIn;
    CheckBox mTermsAndConditions;
    Button signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        init();
    }

    private void init() {
        initViews();
        initListener();
    }

    private void initListener() {
        signUp.setOnClickListener(this);
        mTermsAndConditions.setOnClickListener(this);
        mTvSignIn.setOnClickListener(this);
    }

    private void initViews() {
        mUserName = (EditText) findViewById(R.id.sign_up_user_name);
        mEmail = (EditText) findViewById(R.id.sign_up_email);
        mMobile = (EditText) findViewById(R.id.sign_up_mobile);
        mPassword = (EditText) findViewById(R.id.sign_up_password);
        mConformPassword = (EditText) findViewById(R.id.sign_up_conform_password);
        mTvSignIn = (TextView) findViewById(R.id.already_account);
        mTermsAndConditions = (CheckBox) findViewById(R.id.sign_up_check_box);
        signUp = (Button) findViewById(R.id.sign_up_btn);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sign_up_btn:
                validate();
                break;
            case R.id.already_account:
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(SignUpActivity.this, FirstActivity.class);
        SignUpActivity.this.finish();
        startActivity(intent);
    }

    private void validate() {
        if (mUserName.getText().toString().length() == 0) {
            Toast.makeText(SignUpActivity.this, "UserName Required", Toast.LENGTH_SHORT).show();
        } else if (mEmail.getText().toString().length() == 0) {
            Toast.makeText(SignUpActivity.this, "Email Required", Toast.LENGTH_SHORT).show();
        } else if (mMobile.getText().toString().length() < 10) {
            Toast.makeText(SignUpActivity.this, "Invalid Mobile Number", Toast.LENGTH_SHORT).show();
        } else if (mPassword.getText().toString().length() == 0) {
            Toast.makeText(SignUpActivity.this, "Password Required", Toast.LENGTH_SHORT).show();
        } else if (mConformPassword.getText().toString().length() == 0) {
            Toast.makeText(SignUpActivity.this, "Conform Password Required", Toast.LENGTH_SHORT).show();
        } else {
            insertDataInDataBase();
            mUserName.setText("");
            mPassword.setText("");
            mEmail.setText("");
            mConformPassword.setText("");
            mMobile.setText("");
            Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
            startActivity(intent);
        }
    }

    private void insertDataInDataBase() {
        Registration registration = new Registration();
        MyDatabase myDatabase = new MyDatabase(getApplicationContext());
        registration.setName(mUserName.getText().toString());
        registration.setEmail(mEmail.getText().toString());
        registration.setMobile(mMobile.getText().toString());
        registration.setPassword(mPassword.getText().toString());
        myDatabase.insertIntoRegistration(registration);
    }
}

