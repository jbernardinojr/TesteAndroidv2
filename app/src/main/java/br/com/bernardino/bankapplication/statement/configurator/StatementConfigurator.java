package br.com.bernardino.bankapplication.statement.configurator;

import java.lang.ref.WeakReference;

import br.com.bernardino.bankapplication.interactor.StatementInteractorInput;
import br.com.bernardino.bankapplication.login.LoginInteractorInputImpl;
import br.com.bernardino.bankapplication.login.LoginMainActivity;
import br.com.bernardino.bankapplication.login.LoginRouterImpl;
import br.com.bernardino.bankapplication.login.presenter.LoginPresenterImpl;
import br.com.bernardino.bankapplication.statement.StatementActivity;
import br.com.bernardino.bankapplication.statement.StatementInteractorInputImpl;
import br.com.bernardino.bankapplication.statement.presenter.StatementPresenterImpl;
import br.com.bernardino.bankapplication.statement.router.StatementRouterImpl;

public enum StatementConfigurator {
    INSTANCE;
    public void configure(StatementActivity statementActivity) {

        StatementRouterImpl router = new StatementRouterImpl();
        router.setActivity(new WeakReference<>(statementActivity));

        StatementPresenterImpl presenter = new StatementPresenterImpl();
        presenter.setOutput(new WeakReference<>(statementActivity));


        StatementInteractorInputImpl interactor = new StatementInteractorInputImpl();
        interactor.setOutput(presenter);

        if (statementActivity.getOutput() == null) {
            statementActivity.setOutput(interactor);
        }

        if (statementActivity.getRouter() == null) {
            statementActivity.setRouter(router);
        }
    }
}
