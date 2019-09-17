package br.com.bernardino.bankapplication.login.presenter;

import java.lang.ref.WeakReference;

import br.com.bernardino.bankapplication.model.UserAccount;

public class LoginPresenterImpl implements Contract.LoginPresenter {

    private WeakReference<Contract.LoginActivityInput> mLoginActivity;

    public void setOutput(WeakReference<Contract.LoginActivityInput> mLoginActivity) {
        this.mLoginActivity = mLoginActivity;
    }

    public WeakReference<Contract.LoginActivityInput> getOutput() {
        return mLoginActivity;
    }


    private Contract.LoginActivityInput getLoginActivity() {
        return this.mLoginActivity.get();
    }

    @Override
    public void emptyUserField() {

    }

    @Override
    public void emptyPasswordField() {

    }

    @Override
    public void onSuccessLoginResponse(UserAccount userAccount) {
        if (getLoginActivity() != null) {
            getLoginActivity().onSuccessLogin(userAccount);
        }
    }

    @Override
    public void onErrorLoginResponse(Error error) {
        if (getLoginActivity() != null) {
            getLoginActivity().onErrorLogin(error);
        }
    }
}
