package com.ijunes.timer.auth;

import com.codahale.dropwizard.auth.Authenticator;
import com.codahale.dropwizard.auth.basic.BasicCredentials;
import com.ijunes.timer.core.User;
import com.google.common.base.Optional;
import com.codahale.dropwizard.auth.AuthenticationException;

public class ExampleAuthenticator implements Authenticator<BasicCredentials, User> {
    @Override
    public Optional<User> authenticate(BasicCredentials credentials) throws AuthenticationException {
        if ("secret".equals(credentials.getPassword())) {
            return Optional.of(new User(credentials.getUsername()));
        }
        return Optional.absent();
    }
}
