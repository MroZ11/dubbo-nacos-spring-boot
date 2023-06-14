package org.example.consumer;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 服务提供者和消费者是相对概念 一个服务既可以是提供者也可以是消费者
 * 启动nacos：startup.cmd -m standalone
 * 启动顺序:nacos -> provider -> consumer
 * NacosPropertySources支持多配置源
 */
@EnableDubbo
@SpringBootApplication
public class ConsumerAPP {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerAPP.class, args);
    }
}
