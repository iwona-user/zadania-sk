package com.example.demo;

import org.springframework.web.bind.annotation.PathVariable;

public class HelloNameServiceImp implements HelloNameService {

	@Override
    public String helloName(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

}
