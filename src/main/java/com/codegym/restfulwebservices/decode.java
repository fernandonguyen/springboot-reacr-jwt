package com.codegym.restfulwebservices;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class decode {

    public static void main(String[] args) {

        String encoder = new BCryptPasswordEncoder().encode("hien");
        System.out.printf(encoder);

    }
}
