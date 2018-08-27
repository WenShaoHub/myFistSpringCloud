package com.wen.testdemo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestResponseBody {

    @RequestMapping(value = "testResonseBody")
    public User responseBody(User user){
        user.setId("2");
        user.setName("rong");
        user.setSex("man");
        return  user;

    }

    @RequestMapping(value = "hi")
    @ResponseBody
    public User hi(User user){
        user.setId("1");
        user.setName("wen");
        user.setSex("man");
        return  user;
    }


}
