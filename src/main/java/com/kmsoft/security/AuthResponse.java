package com.kmsoft.security;

import java.util.List;

public class AuthResponse {
    private String token;
    private String username;
    private String roles;

    public AuthResponse(String username, String token, String roles) {
        this.username = username;
        this.token = token;
        this.roles = roles;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        roles = roles;
    }

    public AuthResponse() {
    }
}
