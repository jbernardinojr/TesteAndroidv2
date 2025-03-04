package br.com.bernardino.bankapplication.login;

import java.net.HttpURLConnection;

import br.com.bernardino.bankapplication.interactor.LoginInteractorInput;
import br.com.bernardino.bankapplication.login.presenter.LoginPresenterImpl;
import br.com.bernardino.bankapplication.model.LoginTO;
import br.com.bernardino.bankapplication.network.APIService;
import br.com.bernardino.bankapplication.network.util.APIUtils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginInteractorInputImpl implements LoginInteractorInput {

    private LoginPresenterImpl output;

    public void setOutput(LoginPresenterImpl output) {
        this.output = output;
    }

    @Override
    public void fetchLoginData(String userName, String userPassword) {
        final LoginResponse loginResponse = new LoginResponse();
        APIService apiService = APIUtils.getAPIService();
//        Call<LoginTO> call = apiService.login(userName, userPassword);
        Call<LoginTO> call = apiService.login("test_user", "Test@1");
        call.enqueue(new Callback<LoginTO>() {
            @Override
            public void onResponse(Call<LoginTO> call, Response<LoginTO> response) {
                if (response.code() == HttpURLConnection.HTTP_OK && response.body().getUserAccount() != null) {
                    loginResponse.userAccount = response.body().getUserAccount();
                    getOutput().onSuccessLoginResponse(loginResponse.userAccount);
                } else if (response.body().getError() != null) {
                    loginResponse.error = response.body().getError();
                    getOutput().onErrorLoginResponse(loginResponse.error);
                }
            }

            @Override
            public void onFailure(Call<LoginTO> call, Throwable t) {

            }
        });


    }

    public LoginPresenterImpl getOutput() {
        return this.output;
    }
}