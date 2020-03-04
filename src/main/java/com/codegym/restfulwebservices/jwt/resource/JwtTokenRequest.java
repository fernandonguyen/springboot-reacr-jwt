package com.codegym.restfulwebservices.jwt.resource;

import java.io.Serializable;

public class  JwtTokenRequest implements Serializable {

  private static final long serialVersionUID = -5616176897013108345L;

  private String username;
  private String password;

    //eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJpbjI4bWludXRlcyIsImV4cCI6MTU4Mjc5MTk0NiwiaWF0IjoxNTgyMTg3MTQ2fQ.5XVqJ6OMdzGiWgYevSsUxyQYXfyoOaNoDA63nWBBzmgJJwkTe_UoyulQHbcwqknKn5z-xaClHmBk-vh6Kim_zg

    public JwtTokenRequest() {
        super();
    }

    public JwtTokenRequest(String username, String password) {
        this.setUsername(username);
        this.setPassword(password);
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
