package br.com.bernardino.bankapplication.login.configurator;

import java.lang.ref.WeakReference;

import br.com.bernardino.bankapplication.login.LoginInteractorInputImpl;
import br.com.bernardino.bankapplication.login.LoginMainActivity;
import br.com.bernardino.bankapplication.login.LoginRouterImpl;
import br.com.bernardino.bankapplication.login.presenter.LoginPresenterImpl;

public enum LoginConfigurator {
    INSTANCE;
    public void configure(LoginMainActivity loginMainActivity){

        LoginRouterImpl router = new LoginRouterImpl();
        router.setActivity(new WeakReference<>(loginMainActivity));

        LoginPresenterImpl presenter = new LoginPresenterImpl();
        presenter.setOutput(new WeakReference<>(loginMainActivity));


        LoginInteractorInputImpl interactor = new LoginInteractorInputImpl();
        interactor.setOutput(presenter);

        if (loginMainActivity.getOutput() == null) {
            loginMainActivity.setOutput(interactor);
        }

        if (loginMainActivity.getRouter() == null) {
            loginMainActivity.setRouter(router);
        }
    }
}
