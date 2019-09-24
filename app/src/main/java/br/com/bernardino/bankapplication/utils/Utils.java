package br.com.bernardino.bankapplication.utils;

import android.content.Intent;

import br.com.bernardino.bankapplication.model.UserAccount;

public class Utils {

    public class Constants {
        public static final String USER_ACCOUNT_INTENT = "user_account";
    }

    public static UserAccount getUserAccountFromIntent(Intent intent) {
        if (intent.hasExtra(Constants.USER_ACCOUNT_INTENT)) {
            return intent.getParcelableExtra(Constants.USER_ACCOUNT_INTENT);
        }
        return null;
    }
}
