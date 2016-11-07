package com.mvp.presenter;

import com.mvp.interactor.LoginInteractorImpl;
import com.mvp.repository.interactor.LoginInteractor;
import com.mvp.repository.presenter.LoginPresenter;
import com.mvp.views.view.LoginView;

import java.lang.ref.WeakReference;

/**
 * Created by root on 27/10/16.
 */

public class LoginPresenterImpl implements LoginPresenter, LoginInteractor.OnLoginFinishedListener {

    private WeakReference<LoginView> loginView;
    private LoginInteractor loginInteractor;

    public LoginPresenterImpl(WeakReference<LoginView> loginView) {
        this.loginView = loginView;
        this.loginInteractor = new LoginInteractorImpl();
    }

    @Override
    public void validateCredentials(String username, String password) {
        if (loginView.get() != null) {
            loginView.get().showProgress();
        }

        loginInteractor.login(username, password, this);
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {
        if (loginView != null)
            loginView.clear();
    }

    @Override
    public void onUsernameError() {
        if (loginView.get() != null) {
            loginView.get().setUsernameError();
            loginView.get().hideProgress();
        }
    }

    @Override
    public void onPasswordError() {
        if (loginView.get() != null) {
            loginView.get().setPasswordError();
            loginView.get().hideProgress();
        }
    }

    @Override
    public void onSuccess() {
        if (loginView.get() != null) {
            loginView.get().navigateToHome();
        }
    }
}
