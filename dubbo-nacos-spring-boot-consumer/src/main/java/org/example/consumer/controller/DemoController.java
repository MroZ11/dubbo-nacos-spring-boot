package org.example.consumer.controller;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.annotation.DubboReference;
import org.example.api.service.DemoService;
import org.example.consumer.config.DubboProperties;
import org.example.consumer.config.SpringProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class DemoController {

    /**
     * DubboReference 如果想延迟要指定lazy属性,否则如果服务提供方不在线依赖于该服务的项目也无法启动
     */
    @DubboReference(version = "1.0", group = "dubbo-provider")
    private DemoService demoService;

    @NacosInjected
    private ConfigService configService;

    @Resource
    private DubboProperties dubboProperties;

    @Resource
    private SpringProperties springProperties;

    public DemoController() {
    }


    @GetMapping("sayhello1")
    public String sayHello(String name) {
        return demoService.sayHello(name);
    }

    @GetMapping("getbank")
    public Object getBank(String name) {
        return demoService.getBankInfo(name);
    }

    @GetMapping("sayhello2")
    public String sayhello2(String name) {
        //手动装配 这样的好处是可以动态指定是服务 如果我有两个不同的服务都实现了这个接口 就可以通过不同的group区分来获取不同的服务实现
        ReferenceConfig<DemoService> reference = new ReferenceConfig<>();
        //必须指定接口
        reference.setInterface(DemoService.class);
        //设置版本
        reference.setVersion("1.0");
        //设置分组
        reference.setGroup("dubbo-provider-other");
        DemoService demoService = reference.get();
        return demoService.sayHello(name);
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
