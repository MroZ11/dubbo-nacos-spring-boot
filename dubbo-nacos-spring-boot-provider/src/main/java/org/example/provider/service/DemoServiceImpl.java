package org.example.provider.service;

import org.apache.dubbo.config.annotation.DubboService;
import org.apache.dubbo.rpc.RpcContext;
import org.example.api.service.dto.BankInfo;
import org.example.api.service.DemoService;

import java.math.BigDecimal;
import java.util.Random;

@DubboService(version = "1.0", group = "dubbo-provider")
public class DemoServiceImpl implements DemoService {

    @Override
    public String sayHello(String name) {
        String sessionId = RpcContext.getServerAttachment().getAttachment("sessionId");
        String out = String.format(" Hello %s ,this service provided by %s,version: %s,group: %s,sessionId:%s ", name, "dubbo-nacos-spring-boot-provider", "1.0", "dubbo-provider-other",sessionId);
        System.out.println(out);
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
