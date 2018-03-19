package com.demo.providerserver.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * ProviderController
 *
 * @author qindaorong
 * @create 2018-03-15 3:23 PM
 **/
@RestController
public class ProviderController {
    
    @RequestMapping(value = "/hi")
    public String hi(@RequestParam String name){
        String str = "hi "+ name + ", this is Provider server!";
        return str;
    }
    
    
}
