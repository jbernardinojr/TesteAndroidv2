package br.com.bernardino.bankapplication.statement.router;

import android.content.Intent;

import java.lang.ref.WeakReference;

import br.com.bernardino.bankapplication.model.UserAccount;
import br.com.bernardino.bankapplication.statement.Contract;
import br.com.bernardino.bankapplication.statement.StatementActivity;

public class StatementRouterImpl implements Contract.StatementRouter {

    private WeakReference<StatementActivity> statementActivity;

    public WeakReference<StatementActivity> getStatementActivity() {
        return statementActivity;
    }

    public void setActivity(WeakReference<StatementActivity> statementActivity) {
        this.statementActivity = statementActivity;
    }

    @Override
    public void dataNextScreen(UserAccount userAccount, Intent intent) {

    }

    @Override
    public Intent nextScreen() {
        return null;
    }
}
