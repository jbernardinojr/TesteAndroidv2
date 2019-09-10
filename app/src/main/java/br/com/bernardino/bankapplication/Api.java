package br.com.bernardino.bankapplication;

import java.util.List;

import br.com.bernardino.bankapplication.model.Statement;
import br.com.bernardino.bankapplication.model.UserAccount;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface Api {

    @POST("/api/login")
    Call<UserAccount> login(@Body String user, @Body String pwd);

    @GET("i/statements/{user_id}")
    Call<List<Statement>> groupList(@Path("user_id") int userId);

}
