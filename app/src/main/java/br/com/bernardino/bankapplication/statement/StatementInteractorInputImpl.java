package br.com.bernardino.bankapplication.statement;

import java.net.HttpURLConnection;

import br.com.bernardino.bankapplication.interactor.StatementInteractorInput;
import br.com.bernardino.bankapplication.model.Statement;
import br.com.bernardino.bankapplication.network.APIService;
import br.com.bernardino.bankapplication.network.util.APIUtils;
import br.com.bernardino.bankapplication.statement.presenter.StatementPresenterImpl;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StatementInteractorInputImpl implements StatementInteractorInput {
    private StatementPresenterImpl output;
    private int mUserId;

    public StatementInteractorInputImpl (int userId) {
        mUserId = userId;
        fetchStatement(mUserId);
    }

    public void setOutput(StatementPresenterImpl output) {
        this.output = output;
    }

    public StatementPresenterImpl getOutput () {
        return output;
    }

    @Override
    public void fetchStatement(int userId) {
        APIService apiService = APIUtils.getAPIService();
        Call<Statement> call = apiService.getStatments(userId);
        StatementResponse statementResponse = new StatementResponse();

        call.enqueue(new Callback<Statement>() {
            @Override
            public void onResponse(Call<Statement> call, Response<Statement> response) {
                if (response.code() == HttpURLConnection.HTTP_OK && response.body() != null) {
                    statementResponse.statement = response.body();
                    getOutput().onSuccessStatementResponse(statementResponse.statement);
                } else if (response.body() != null && response.body().getError() != null) {
                    statementResponse.error = response.body().getError();
                    getOutput().onErrorStatementResponse(statementResponse.error);
                }
            }

            @Override
            public void onFailure(Call<Statement> call, Throwable t) {

            }
        });
    }
}
