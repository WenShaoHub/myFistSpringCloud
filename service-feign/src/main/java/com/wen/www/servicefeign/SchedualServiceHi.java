package com.wen.www.servicefeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "server-client") // 通过@ FeignClient（“服务名”），来指定调用哪个服务。比如在代码中调用了service-client服务的“/hi”接口
public interface SchedualServiceHi {

    @RequestMapping(value = "/hi",method = RequestMethod.GET)
    String sayHiFrom(@RequestParam(value = "name") String name); //@RequestParam 获取参数，value是防止参数名不一样


}
