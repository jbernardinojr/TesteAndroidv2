package br.com.bernardino.bankapplication.utils;

import android.content.Intent;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

import br.com.bernardino.bankapplication.model.UserAccount;

public class Utils {

    public class Constants {
        public static final String USER_ACCOUNT_INTENT = "user_account";
    }

    public static String formatDate(String date) {
        Locale locale = new Locale("pt-BR");
        SimpleDateFormat simpleFormato = new SimpleDateFormat("yyyy-MM-dd", locale);
        String format = null;
        try {
            Date dateFormat = simpleFormato.parse(date);
            format = new SimpleDateFormat("dd-MM-yyyy", locale).format(dateFormat);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null != format ? format : date ;
    }

    public static UserAccount getUserAccountFromIntent(Intent intent) {
        if (intent.hasExtra(Constants.USER_ACCOUNT_INTENT)) {
            return intent.getParcelableExtra(Constants.USER_ACCOUNT_INTENT);
        }
        return null;
    }
}
