package com.codegym.restfulwebservices.basic;

import com.codegym.restfulwebservices.bean.HelloWorldBean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BasicAuthenticationController {

    @GetMapping(path = "/basicauth")
    public AuthenticationBean helloWorldBean(){
        return new AuthenticationBean("You are authenticated");
    }

}
