package com.mvp.views.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.mvp.R;
import com.mvp.presenter.LoginPresenterImpl;
import com.mvp.repository.presenter.LoginPresenter;
import com.mvp.views.view.LoginView;

import java.lang.ref.WeakReference;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, LoginView{

    private ProgressBar progressBar;
    private EditText username;
    private EditText password;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        progressBar = (ProgressBar) findViewById(R.id.progress);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        findViewById(R.id.button).setOnClickListener(this);
        WeakReference<LoginView> reference = new WeakReference<LoginView>(this);
        presenter = new LoginPresenterImpl(reference);
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setUsernameError() {
        username.setError("User name required");
    }

    @Override
    public void setPasswordError() {
        password.setError("Password required");
    }

    @Override
    public void navigateToHome() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    @Override
    public void onClick(View v) {
        presenter.validateCredentials(username.getText().toString(), password.getText().toString());
    }
}
