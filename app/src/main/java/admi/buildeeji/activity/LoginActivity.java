package admi.buildeeji.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

import admi.buildeeji.R;
import admi.buildeeji.Util;
import admi.buildeeji.database.MyDatabase;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    EditText mUserName;
    EditText mPassword;
    TextView forgetPassword;
    TextView createNewAccount;
    Button signIn;
    MyDatabase myDatabase;

    TextView TV_Hindi, TV_English, TV_French, Tv_Telugu;
    Locale mylocale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }

    @Override
    protected void onPause() {
        super.onPause();
        LoginActivity.this.finish();
    }

    private void init() {
        initViews();
        initListener();
    }

    private void initListener() {
        signIn.setOnClickListener(this);
        forgetPassword.setOnClickListener(this);
        createNewAccount.setOnClickListener(this);
    }

    private void initViews() {
        myDatabase = new MyDatabase(this);
        mUserName = (EditText) findViewById(R.id.sign_in_username);
        mPassword = (EditText) findViewById(R.id.sign_in_password);
        forgetPassword = (TextView) findViewById(R.id.tv_forget_password);
        createNewAccount = (TextView) findViewById(R.id.tv_create_new_account);
        signIn = (Button) findViewById(R.id.sign_in_btn);

        TV_Hindi = (TextView) findViewById(R.id.TVHindi);
        TV_English = (TextView) findViewById(R.id.TVEnglish);
        Tv_Telugu = (TextView) findViewById(R.id.TVTelugu);


        //Set Hindi Language
        TV_Hindi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this, "Hindi Language", Toast.LENGTH_SHORT).show();
                setLanguage("hindi");
            }
        });

        //Set English Language
        TV_English.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this, "English Language", Toast.LENGTH_SHORT).show();
                setLanguage("english");
            }
        });


        //Set Telugu Language
        Tv_Telugu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this, "Telugu Language", Toast.LENGTH_SHORT).show();
                setLanguage("Telugu");
            }
        });
    }

    //Change language Method
    protected void setLanguage(String language) {
        mylocale = new Locale(language);
        Resources resources = getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();
        Configuration conf = resources.getConfiguration();
        conf.locale = mylocale;
        resources.updateConfiguration(conf, dm);
        Intent refreshIntent = new Intent(LoginActivity.this, LoginActivity.class);
        finish();
        startActivity(refreshIntent);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sign_in_btn:
                validate();
                break;
            case R.id.tv_forget_password:
                Intent forgotIntent = new Intent(LoginActivity.this, ForgetActivity.class);
                startActivity(forgotIntent);
                break;
            case R.id.tv_create_new_account:
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(LoginActivity.this, FirstActivity.class);
        startActivity(intent);
    }

    private void validate() {
        if (mUserName.getText().toString().length() == 0) {
            Toast.makeText(LoginActivity.this, "UserName/mobile/Email Required", Toast.LENGTH_SHORT).show();
        } else if (mPassword.getText().toString().length() == 0) {
            Toast.makeText(LoginActivity.this, "Password Required", Toast.LENGTH_SHORT).show();
        } else {
            checkPassword();

        }
    }

    private void checkPassword() {
        String name = mUserName.getText().toString().trim();
        String userName = "'" + name + "'";
        String password = myDatabase.retrievePassword(userName, mPassword.getText().toString());
        if (password.equals(mPassword.getText().toString().trim())) {
            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(Util.LOGIN_STATUS_KEY, Util.LOGIN_STATUS);
            editor.commit();
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            intent.putExtra(Util.LOGIN, this.getClass().getSimpleName());
            startActivity(intent);
        } else {
            Toast.makeText(LoginActivity.this, "User Name or Password Incorrect", Toast.LENGTH_SHORT).show();
        }
    }
}
