package com.neutrino.dawn.security.service;

import java.io.Serializable;

/**
 * @author kousq
 * @Date 2023/05/01 17:39
 * @Version 1.0.0
 * @Description:
 */
public class AuthenticationResponse implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwt;

    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getToken() {
        return this.jwt;
    }
}
