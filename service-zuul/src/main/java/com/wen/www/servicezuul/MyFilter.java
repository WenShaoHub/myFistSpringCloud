package com.wen.www.servicezuul;

import com.netflix.ribbon.proxy.annotation.Http;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class MyFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(MyFilter.class);

    @Override
    public String filterType() {  //filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
        return "pre";   //pre：路由之前 routing 路由之时 post：路由之后 error：发生错误
    }

    @Override
    public int filterOrder() {  //表示过滤的顺序

        return 0;
    }

    @Override
    public boolean shouldFilter() {  //这里可以写逻辑判断，是否要过滤，本文true,永远过滤。
        return true;
    }

    @Override      // 过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        log.info(String.format("%s >>> %s",request.getMethod(),request.getRequestURL().toString()));
        Object accessToken = request.getParameter("token");
        if(accessToken == null){
            log.warn("token为kong");
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(401);
            try{
                requestContext.getResponse().getWriter().write("token is empty");
            }catch (Exception e){
                return null;
            }
        }
//        try {
//            requestContext.getResponse().getWriter().write("token is "+accessToken.toString());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        log.info("ok");
        return null;
    }
}
