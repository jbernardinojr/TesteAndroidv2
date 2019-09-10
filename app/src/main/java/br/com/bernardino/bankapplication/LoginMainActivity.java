package br.com.bernardino.bankapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginMainActivity extends AppCompatActivity {

    private LoginInteractor mOutput;
    private EditText mEditTextUserName;
    private EditText mEditTextPassword;
    private Button mBtnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);

        mOutput = new LoginInteractor();

        setViews();
    }

    private void setViews() {
        mEditTextUserName = findViewById(R.id.et_user);
        mEditTextPassword = findViewById(R.id.et_pwd);
        mBtnLogin = findViewById(R.id.btn_login);

        mBtnLogin.setOnClickListener(this::onBtnLoginClickListener);
    }

    private void onBtnLoginClickListener(View view) {
        String user = mEditTextUserName.getText().toString().trim();
        String pwd = mEditTextPassword.getText().toString().trim();

        mOutput.fetchLoginData(user, pwd);
    }
}
