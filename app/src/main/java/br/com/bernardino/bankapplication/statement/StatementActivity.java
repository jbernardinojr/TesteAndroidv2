package br.com.bernardino.bankapplication.statement;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import br.com.bernardino.bankapplication.R;
import br.com.bernardino.bankapplication.model.UserAccount;
import br.com.bernardino.bankapplication.utils.Utils;

public class StatementActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statement);

        UserAccount userAccount = Utils.getUserAccountFromIntent(getIntent());
    }

}
