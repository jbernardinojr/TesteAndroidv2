package br.com.bernardino.bankapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginTO {

    @SerializedName("userAccount")
    @Expose
    private UserAccount userAccount;
    @SerializedName("error")
    @Expose
    private Error error;

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

}
