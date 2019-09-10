package br.com.bernardino.bankapplication;

import java.net.HttpURLConnection;

import br.com.bernardino.bankapplication.interactor.LoginInteractorInput;
import br.com.bernardino.bankapplication.model.UserAccount;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginInteractor implements LoginInteractorInput {

    @Override
    public void fetchLoginData(String userName, String userPassword) {
        final LoginResponse loginResponse = new LoginResponse();
        Api api = RetrofitClientInstance.getRetrofitInstance().create(Api.class);
        Call<UserAccount> call = api.login(userName, userPassword);
        call.enqueue(new Callback<UserAccount>() {
            @Override
            public void onResponse(Call<UserAccount> call, Response<UserAccount> response) {
                if (response.code() == HttpURLConnection.HTTP_OK) {
                    loginResponse.userAccount = response.body();
                }
            }

            @Override
            public void onFailure(Call<UserAccount> call, Throwable t) {
                loginResponse.userAccount = null;
            }
        });
    }
}
