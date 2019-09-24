package br.com.bernardino.bankapplication.statement.presenter;

import java.lang.ref.WeakReference;

import br.com.bernardino.bankapplication.model.Statement;
import br.com.bernardino.bankapplication.statement.Contract;

public class StatementPresenterImpl implements Contract.StatementPresenter {

    private WeakReference<Contract.StatementActivityInput> mStatementActivity;

    public void setOutput(WeakReference<Contract.StatementActivityInput> mStatementActivity) {
        this.mStatementActivity = mStatementActivity;
    }

    public WeakReference<Contract.StatementActivityInput> getOutput() {
        return mStatementActivity;
    }


    private Contract.StatementActivityInput getStatementActivity() {
        return this.mStatementActivity.get();
    }

    @Override
    public void onSuccessStatementResponse(Statement statement) {
        if (getStatementActivity() != null) {
            getStatementActivity().onSuccessStatement(statement);
        }
    }

    @Override
    public void onErrorStatementResponse(Error error) {
        if (getStatementActivity() != null) {
            getStatementActivity().onErrorStatement(error);
        }
    }
}
