package com.module.java.interactor;

import com.module.java.Network.RestInterface;
import com.module.java.listener.OnLoginFinishedListener;

import org.fest.assertions.Assert;
import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import rx.Observable;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

import static org.junit.Assert.assertTrue;

public class LoginInteractorImplTest {

    RestInterface restInterface;
    Observable<Object> loginObservable;

    @Before
    public void setUp() {
        loginObservable = creatLoginObservable();
        restInterface = Mockito.mock(RestInterface.class);
        Mockito.when(restInterface.login()).thenReturn(loginObservable);

    }

    @Test
    public void returnSuccessfulIfValidCredentialsProvided() throws Exception {

        LoginInteractor loginInteractor = new LoginInteractorImpl(restInterface);
        loginInteractor.login("dfsdf", "password", new OnLoginFinishedListener() {
            @Override
            public void onUsernameError() {
                // should never be called
                Assertions.assertThat(false).isTrue();
                assertTrue(false);
            }

            @Override
            public void onPasswordError() {
                // should never be called
                Assertions.assertThat(false).isTrue();
            }

            @Override
            public void onSuccess() {
                System.out.println("onSuccess Called");
                Assertions.assertThat(true).isTrue();
            }

            @Override
            public void onLoginError() {
                // should never be called
                Assertions.assertThat(false).isTrue();
            }
        });
    }

    @Test
    public void passwordErrorShouldBeCalledIfNotValidPassword() {
        LoginInteractor loginInteractor = new LoginInteractorImpl(restInterface);

        loginInteractor.login("dfsdf", "", new OnLoginFinishedListener() {
            @Override
            public void onUsernameError() {
                // should never be called
                Assertions.assertThat(false).isTrue();
            }

            @Override
            public void onPasswordError() {
                System.out.println("onPasswordError Called");
                Assertions.assertThat(true).isTrue();
            }

            @Override
            public void onSuccess() {
                // should never be called
                Assertions.assertThat(false).isTrue();
            }

            @Override
            public void onLoginError() {
                // should never be called
                Assertions.assertThat(false).isTrue();
            }
        });
    }

    @Test
    public void usernameErrorShouldBeCalledIfNotValidUsername() {
        LoginInteractor loginInteractor = new LoginInteractorImpl(restInterface);

        loginInteractor.login("", "dsadas", new OnLoginFinishedListener() {
            @Override
            public void onUsernameError() {
                System.out.println("onUsernameError Called");
                Assertions.assertThat(true).isTrue();
            }

            @Override
            public void onPasswordError() {
                // should never be called
                Assertions.assertThat(false).isTrue();
            }

            @Override
            public void onSuccess() {
                // should never be called
                Assertions.assertThat(false).isTrue();
            }

            @Override
            public void onLoginError() {
                // should never be called
                Assertions.assertThat(false).isTrue();
            }
        });
    }

    private Observable<Object> creatLoginObservable() {
        return Observable.just(new Object()).subscribeOn(Schedulers.immediate()).observeOn
                (Schedulers.immediate());
    }
}