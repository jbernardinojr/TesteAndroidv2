package br.com.bernardino.bankapplication.login;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.com.bernardino.bankapplication.R;
import br.com.bernardino.bankapplication.login.configurator.LoginConfigurator;
import br.com.bernardino.bankapplication.login.presenter.Contract;
import br.com.bernardino.bankapplication.model.UserAccount;

public class LoginMainActivity extends AppCompatActivity implements Contract.LoginActivityInput {

    private LoginInteractorInputImpl mOutput;
    private EditText mEditTextUserName;
    private EditText mEditTextPassword;
    private Button mBtnLogin;
    private LoginRouterImpl mRouter;

    public LoginRouterImpl getRouter() {
        return mRouter;
    }

    public void setRouter(LoginRouterImpl mRouter) {
        this.mRouter = mRouter;
    }

    public LoginInteractorInputImpl getOutput() {
        return mOutput;
    }

    public void setOutput(LoginInteractorInputImpl mOutput) {
        this.mOutput = mOutput;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);

        setViews();

        LoginConfigurator.INSTANCE.configure(this);


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



    @Override
    public void notifyErrorToUser(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message);
        builder.setPositiveButton(R.string.login_error_ok, (dialogInterface, i) -> {});
        builder.create().show();

        mBtnLogin.setEnabled(true);
    }

    @Override
    public void onSuccessLogin(UserAccount userAccount) {
        Intent intent = mRouter.nextScreen();
        mRouter.dataNextScreen(userAccount, intent);
        startActivity(intent);
        finish();
    }

    @Override
    public void onErrorLogin(Error error) {
        notifyErrorToUser(error.getMessage());
    }
}
