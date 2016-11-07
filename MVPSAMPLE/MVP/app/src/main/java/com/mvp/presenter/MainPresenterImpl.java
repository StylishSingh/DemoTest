/*
 *
 *  * Copyright (C) 2014 Antonio Leiva Gordillo.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package com.mvp.presenter;

import com.mvp.interactor.MainInteractorImpl;
import com.mvp.repository.interactor.MainInteractor;
import com.mvp.repository.presenter.MainPresenter;
import com.mvp.views.view.MainView;

import java.lang.ref.WeakReference;
import java.util.List;

public class MainPresenterImpl implements MainPresenter, MainInteractor.OnFinishedListener {

    private WeakReference<MainView> mainView;
    private MainInteractor mainInteractor;

    public MainPresenterImpl(WeakReference<MainView> mainView) {
        this.mainView = mainView;
        mainInteractor = new MainInteractorImpl();
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onResume() {
        if (mainView.get() != null) {
            mainView.get().showProgress();
        }

        mainInteractor.fetchItems(this);
    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }


    @Override
    public void onDestroy() {
        if (mainView != null)
            mainView.clear();
    }


    @Override
    public void onItemClicked(int position) {
        if (mainView != null) {
            mainView.get().showMessage(String.format("Position %d clicked", position + 1));
        }
    }

    @Override
    public void onFinished(List<String> items) {
        if (mainView != null) {
            mainView.get().setItems(items);
            mainView.get().hideProgress();
        }
    }
}
