package br.com.bernardino.bankapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Statement {
    @SerializedName("statementList")
    @Expose
    private List<StatementTO> statementList = null;
    @SerializedName("error")
    @Expose
    private Error error;

    public List<StatementTO> getStatementList() {
        return statementList;
    }

    public void setStatementList(List<StatementTO> statementList) {
        this.statementList = statementList;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;

    }
}
