package br.com.bernardino.bankapplication.statement;

import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import br.com.bernardino.bankapplication.R;
import br.com.bernardino.bankapplication.interactor.StatementInteractorInput;
import br.com.bernardino.bankapplication.login.LoginRouterImpl;
import br.com.bernardino.bankapplication.model.Statement;
import br.com.bernardino.bankapplication.model.UserAccount;
import br.com.bernardino.bankapplication.statement.configurator.StatementConfigurator;
import br.com.bernardino.bankapplication.statement.router.StatementRouterImpl;
import br.com.bernardino.bankapplication.utils.Utils;

public class StatementActivity extends AppCompatActivity implements Contract.StatementActivityInput {

    private StatementInteractorInput mOutput;
    private StatementRouterImpl mRouter;

    public StatementInteractorInput getOutput() {
        return mOutput;
    }

    public void setOutput(StatementInteractorInput mOutput) {
        this.mOutput = mOutput;
    }

    public StatementRouterImpl getRouter() {
        return mRouter;
    }

    public void setRouter(StatementRouterImpl mRouter) {
        this.mRouter = mRouter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statement);

        UserAccount userAccount = Utils.getUserAccountFromIntent(getIntent());
        StatementConfigurator.INSTANCE.configure(this);
    }

    @Override
    public void notifyErrorToUser(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message);
        builder.setPositiveButton(R.string.login_error_ok, (dialogInterface, i) -> {});
        builder.create().show();
    }

    @Override
    public void onLogoutPressed() {

    }

    @Override
    public void onSuccessStatement(Statement statement) {
        //put the data on the list
    }

    @Override
    public void onErrorStatement(Error error) {
        if (null != error) {
            notifyErrorToUser(error.getMessage());
        }
    }
}
