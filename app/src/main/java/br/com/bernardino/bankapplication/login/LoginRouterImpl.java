package br.com.bernardino.bankapplication.login;

import android.content.Intent;

import java.lang.ref.WeakReference;

import br.com.bernardino.bankapplication.statement.StatementActivity;
import br.com.bernardino.bankapplication.login.presenter.Contract;
import br.com.bernardino.bankapplication.model.UserAccount;
import br.com.bernardino.bankapplication.utils.Utils;

public class LoginRouterImpl implements Contract.LoginRouter {

    public WeakReference<LoginMainActivity> getLoginActivity() {
        return mLoginActivity;
    }

    private WeakReference<LoginMainActivity> mLoginActivity;

    public void setActivity(WeakReference<LoginMainActivity> loginActivity) {
        mLoginActivity = loginActivity;
    }

    @Override
    public void dataNextScreen(UserAccount userAccount, Intent intent) {
        intent.putExtra(Utils.Constants.USER_ACCOUNT_INTENT, userAccount);
    }

    @Override
    public Intent nextScreen() {
        return new Intent(mLoginActivity.get(), StatementActivity.class);
    }
}
