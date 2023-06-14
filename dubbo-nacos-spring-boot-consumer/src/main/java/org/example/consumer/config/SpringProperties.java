package org.example.consumer.config;

import com.alibaba.nacos.api.config.annotation.NacosConfigurationProperties;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.context.annotation.Configuration;

@Configuration
@NacosConfigurationProperties(dataId = "springcloud-service-one.properties", autoRefreshed = true, groupId = "DEFAULT_GROUP")
public class SpringProperties {

    @NacosValue(value = "${useLocalCache:false}", autoRefreshed = true)
    private Boolean useLocalCache;

    @NacosValue(value = "${customerName:unknown}", autoRefreshed = true)
    private String customerName;

    public Boolean getUseLocalCache() {
        return useLocalCache;
    }

    public void setUseLocalCache(Boolean useLocalCache) {
        this.useLocalCache = useLocalCache;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
