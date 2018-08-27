package com.wen.www.serviceribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

        @Autowired
        HelloService helloService;

        @GetMapping(value = "/hi")  // @GetMapping是一个组合注解，是@RequestMapping(method = RequestMethod.GET)的缩写。
        public String hi(@RequestParam String name) {
            System.out.println("=============走ribbon这边============");
            return helloService.hiService(name);
        }
    }
