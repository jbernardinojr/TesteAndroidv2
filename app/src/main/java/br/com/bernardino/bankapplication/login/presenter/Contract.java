package br.com.bernardino.bankapplication.login.presenter;

import android.content.Intent;

import br.com.bernardino.bankapplication.model.UserAccount;

public interface Contract {

    interface LoginPresenter {
        void emptyUserField();
        void emptyPasswordField();
        void onSuccessLoginResponse(UserAccount userAccount);
        void onErrorLoginResponse(Error error);
    }

    interface LoginRouter {
        void dataNextScreen(UserAccount userAccount, Intent intent);
        Intent nextScreen();
    }

    interface LoginActivityInput {
        void notifyErrorToUser(String message);
        void onSuccessLogin(UserAccount userAccount);
        void onErrorLogin(Error error);
    }

}
