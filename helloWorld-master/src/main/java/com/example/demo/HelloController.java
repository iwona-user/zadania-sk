package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final HelloService   helloServiceInterface;
    private  final HelloNameService   HelloNameServiceInterface;
    
    public HelloController(final HelloService helloServiceInterface, final HelloNameService HelloNameServiceInterface) {
        this.helloServiceInterface = helloServiceInterface;
        this. HelloNameServiceInterface=HelloNameServiceInterface;
    }

    @GetMapping("/hello")
    public String hello(){
        return helloServiceInterface.sayHello();
    }

    @GetMapping("/hello/{name}")
    public String sayhelloName(@PathVariable String name) {
        return HelloNameServiceInterface.helloName(name);
    }
}
