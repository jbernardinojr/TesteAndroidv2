package br.com.bernardino.bankapplication.statement;

import android.content.Intent;

import br.com.bernardino.bankapplication.model.Statement;
import br.com.bernardino.bankapplication.model.UserAccount;

public interface Contract {
    interface StatementPresenter {
        void onSuccessStatementResponse(Statement statement);
        void onErrorStatementResponse(Error error);
    }

    interface StatementActivityInput {
        void notifyErrorToUser(String message);
        void showProgressDialog();
        void onLogoutPressed();
        void onSuccessStatement(Statement statement);
        void onErrorStatement(Error error);
    }

    interface StatementRouter {
        void dataNextScreen(UserAccount userAccount, Intent intent);
        Intent nextScreen();
    }
}
