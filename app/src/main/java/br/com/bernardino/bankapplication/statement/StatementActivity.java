package br.com.bernardino.bankapplication.statement;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import br.com.bernardino.bankapplication.R;
import br.com.bernardino.bankapplication.interactor.StatementInteractorInput;
import br.com.bernardino.bankapplication.model.Statement;
import br.com.bernardino.bankapplication.model.UserAccount;
import br.com.bernardino.bankapplication.statement.configurator.StatementConfigurator;
import br.com.bernardino.bankapplication.statement.router.StatementRouterImpl;
import br.com.bernardino.bankapplication.utils.Utils;

public class StatementActivity extends AppCompatActivity implements Contract.StatementActivityInput {

    private StatementInteractorInput mOutput;
    private StatementRouterImpl mRouter;
    private TextView mUserName;
    private TextView mUserAgencyAccount;
    private TextView mUserAccountBalance;
    private RecyclerView mRecyclerViewStatement;
    private ImageButton mLogout;
    private ProgressDialog mDialog;
    private RecyclerView.LayoutManager mLayout;
    private UserAccount mUserAccount;


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

        setViews();

        mUserAccount = Utils.getUserAccountFromIntent(getIntent());
        StatementConfigurator.INSTANCE.configure(this, mUserAccount.getUserId());
    }

    private void setViews() {
        mUserName = findViewById(R.id.tv_user_name);
        mUserAgencyAccount = findViewById(R.id.tv_user_agency_account);
        mUserAccountBalance = findViewById(R.id.tv_user_account_balance);
        mRecyclerViewStatement = findViewById(R.id.rv_statement);
        mLogout = findViewById(R.id.ib_logout);
        mDialog = new ProgressDialog(this);
        mDialog.setTitle(R.string.title_dialog_loading);
        mLayout = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        showProgressDialog();

        mLogout.setOnClickListener(this::onBtnLogoutClickListener);
    }

    private void onBtnLogoutClickListener(View view) {

    }

    @Override
    public void notifyErrorToUser(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(message);
        builder.setPositiveButton(R.string.login_error_ok, (dialogInterface, i) -> {});
        builder.create().show();
    }

    @Override
    public void showProgressDialog() {
        mDialog.show();
    }

    @Override
    public void onLogoutPressed() {

    }

    @Override
    public void onSuccessStatement(Statement statement) {
        //put the data on the list
        String userAccountAgency = getString(
                R.string.bank_account_agency
                , mUserAccount.getAgency()
                , mUserAccount.getBankAccount()
        );

        String userBalance = getString(
                R.string.bank_account_balance
                , String.valueOf(mUserAccount.getBalance())
        );

        mDialog.dismiss();
        mUserName.setText(mUserAccount.getName());
        mUserAgencyAccount.setText(userAccountAgency);
        mUserAccountBalance.setText(userBalance);
        mRecyclerViewStatement.setAdapter(new StatementAdapter(statement.getStatementList(), this));
        mRecyclerViewStatement.setLayoutManager(mLayout);
    }

    @Override
    public void onErrorStatement(Error error) {
        if (null != error) {
            notifyErrorToUser(error.getMessage());
        }
    }
}
