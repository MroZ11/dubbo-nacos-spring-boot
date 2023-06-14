package org.example.consumer.controller;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.config.annotation.NacosConfigurationProperties;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.apache.dubbo.config.annotation.DubboReference;
import org.example.api.service.DemoService;
import org.example.consumer.config.DubboProperties;
import org.example.consumer.config.SpringProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class DemoController {

    @DubboReference(version = "1.0", group = "dubbo")
    private DemoService demoService;

    @NacosInjected
    private ConfigService configService;

    @Resource
    private DubboProperties dubboProperties;

    @Resource
    private SpringProperties springProperties;


    @GetMapping("sayhello")
    public String sayHello(String name) {
        return demoService.sayHello(name);
    }

    @GetMapping("getbank")
    public Object getBank(String name) {
        return demoService.getBankInfo(name);
    }

    @GetMapping("getconfig1")
    public Object getconfig1() throws NacosException {
        //String a = configService.getConfig("dubbo.properties","nacos-proj",5000);
        String a = dubboProperties.getCustomerName();
        return a;
    }

    @GetMapping("getconfig2")
    public Object getconfig2() throws NacosException {
        //String a = configService.getConfig("dubbo.properties","nacos-proj",5000);
        String a = springProperties.getCustomerName();
        return a;
    }

}
