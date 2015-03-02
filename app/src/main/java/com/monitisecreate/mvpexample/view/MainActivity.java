package com.monitisecreate.mvpexample.view;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.monitisecreate.mvpexample.R;
import com.monitisecreate.mvpexample.presenter.LoginPresenter;
import com.monitisecreate.mvpexample.presenter.LoginPresenterImpl;


public class MainActivity extends ActionBarActivity implements LoginView, View.OnClickListener {

    private ProgressBar progressBar;
    private EditText username;
    private EditText password;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.progress);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        findViewById(R.id.button).setOnClickListener(this);
        loginPresenter = new LoginPresenterImpl(this);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void setUsernameError() {
        username.setError("Error username!");
    }

    @Override
    public void setPasswordError() {
        password.setError("Error password!");
    }

    @Override
    public void showToastError() {
        Toast.makeText(this, "Error during login", Toast.LENGTH_LONG).show();
    }

    @Override
    public void navigateSomewhere() {
        // login success go somewhere
        startActivity(ListActivity.newInstance(this));
    }

    @Override
    public void onClick(View v) {
        //validate credentials
        loginPresenter.validateCredentials(username.getText().toString(), password.getText().toString());
    }
}
