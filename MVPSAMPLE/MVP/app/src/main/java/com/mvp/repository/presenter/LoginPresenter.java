package com.mvp.repository.presenter;

import com.mvp.repository.baserepo.LifeCyclePresenter;

/**
 * Created by root on 27/10/16.
 */

public interface LoginPresenter extends LifeCyclePresenter {
    void validateCredentials(String username, String password);

    void onDestroy();
}
