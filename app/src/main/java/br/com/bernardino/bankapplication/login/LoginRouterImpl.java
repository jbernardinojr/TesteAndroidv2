package br.com.bernardino.bankapplication.login;

import android.content.Intent;

import java.lang.ref.WeakReference;

import br.com.bernardino.bankapplication.CurrencyActivity;
import br.com.bernardino.bankapplication.login.presenter.Contract;
import br.com.bernardino.bankapplication.model.UserAccount;

public class LoginRouterImpl implements Contract.LoginRouter {

    private static final String USER_ACCOUNT_INTENT = "user_account";

    public WeakReference<LoginMainActivity> getLoginActivity() {
        return mLoginActivity;
    }

    private WeakReference<LoginMainActivity> mLoginActivity;

    public void setActivity(WeakReference<LoginMainActivity> loginActivity) {
        mLoginActivity = loginActivity;
    }

    @Override
    public void dataNextScreen(UserAccount userAccount, Intent intent) {
        intent.putExtra(USER_ACCOUNT_INTENT, userAccount);
    }

    @Override
    public Intent nextScreen() {
        return new Intent(mLoginActivity.get(), CurrencyActivity.class);
    }
}
