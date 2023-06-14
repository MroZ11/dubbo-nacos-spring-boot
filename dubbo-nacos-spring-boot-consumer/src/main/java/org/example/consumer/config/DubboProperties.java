package org.example.consumer.config;

import com.alibaba.nacos.api.config.annotation.NacosConfigurationProperties;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.context.annotation.Configuration;

/**
 * 这种模式的弊端在于会相互污染
 * @NacosPropertySources({
 *         @NacosPropertySource(dataId = "user.info",  groupId = "springbootvue", autoRefreshed = true),
 *         @NacosPropertySource(dataId = "user.info.pre",  groupId = "springbootvue", autoRefreshed = true),
 *         @NacosPropertySource(dataId = "user.info.test",  groupId = "springbootvue", autoRefreshed = true),
 *         @NacosPropertySource(dataId = "user.info.test",  groupId = "springbootvuetest", autoRefreshed = true)})
 *
 *
 * 使用@NacosConfigurationProperties 配置POJO 可以精确的指定配置文件
 *
 */
@Configuration
@NacosConfigurationProperties(dataId = "dubbo.properties", groupId = "nacos-proj", autoRefreshed = true)
public class DubboProperties {

    @NacosValue(value = "${customerName:unknown}", autoRefreshed = true)
    private String customerName;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
