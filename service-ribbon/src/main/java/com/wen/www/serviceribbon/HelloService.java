package com.wen.www.serviceribbon;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {
    @Autowired
    RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "hiError")    //断路器，服务无效时调用这个”hiError"方法
    public String hiService(String name){
        //  getForObject()发送一个HTTP GET请求，返回的请求体将映射为一个对象
        return restTemplate.getForObject("http://server-client/hi?name="+name,String.class);
    }
    public String hiError(String name) {
        return "hi,"+name+",sorry,error!";
    }


}
