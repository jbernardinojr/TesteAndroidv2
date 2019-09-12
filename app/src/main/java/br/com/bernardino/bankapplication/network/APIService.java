package br.com.bernardino.bankapplication.network;

import java.util.List;

import br.com.bernardino.bankapplication.model.Statement;
import br.com.bernardino.bankapplication.model.UserAccount;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface Api {

    @POST("login")
    @FormUrlEncoded
    Call<UserAccount> login(@Field("user") String user, @Field("password") String pwd);

    @GET("statements/{user_id}")
    Call<List<Statement>> groupList(@Path("user_id") int userId);

}
