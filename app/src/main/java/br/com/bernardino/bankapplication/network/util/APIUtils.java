package br.com.bernardino.bankapplication.network.util;

import br.com.bernardino.bankapplication.network.APIService;
import br.com.bernardino.bankapplication.network.RetrofitClient;

public class APIUtils {

    private static final String BASE_URL = "https://bank-app-test.herokuapp.com";

    public static APIService getAPIService() {

        return RetrofitClient.getRetrofitInstance(BASE_URL).create(APIService.class);
    }
}
