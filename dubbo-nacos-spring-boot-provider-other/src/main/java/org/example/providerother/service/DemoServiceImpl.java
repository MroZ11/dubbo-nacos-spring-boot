package org.example.providerother.service;

import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.rpc.RpcContext;
import org.example.api.service.DemoService;
import org.example.api.service.dto.BankInfo;

import java.math.BigDecimal;
import java.util.Random;

@DubboService(version = "1.0", group = "dubbo-provider-other")
public class DemoServiceImpl implements DemoService {

    @Override
    public String sayHello(String name) {
        //A->B B端通过getServerAttachment()获取
        String sessionId = RpcContext.getServerAttachment().getAttachment("sessionId");
        String out = String.format(" Hello %s ,this service provided by %s,version: %s,group: %s,sessionId:%s ", name, "dubbo-nacos-spring-boot-provider-other", "1.0", "dubbo-provider-other",sessionId);
        System.out.println(out);
        //B-->A
        //使用getServerContext()回传数据给A
        RpcContext.getServerContext().setAttachment("userName",name);
        return out;
    }

    @Override
    public BankInfo getBankInfo(String name) {
        Random random = new Random();
        BankInfo bankInfo = new BankInfo();
        bankInfo.setName(name);
        bankInfo.setBalance(BigDecimal.valueOf(random.nextInt(10000)));
        return bankInfo;
    }

}
