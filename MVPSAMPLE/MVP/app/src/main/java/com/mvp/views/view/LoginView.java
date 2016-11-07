package com.mvp.views.view;

/**
 * Created by root on 27/10/16.
 */

public interface LoginView {

    void showProgress();

    void hideProgress();

    void setUsernameError();

    void setPasswordError();

    void navigateToHome();
}
