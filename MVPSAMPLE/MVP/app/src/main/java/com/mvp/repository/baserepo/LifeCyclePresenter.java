package com.mvp.repository.baserepo;

/**
 * Created by root on 27/10/16.
 */

public interface LifeCyclePresenter {

    void onCreate();

    void onStart();

    void onResume();

    void onPause();

    void onStop();

    void onDestroy();

}
