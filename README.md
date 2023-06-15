# dubbo-nacos-spring-boot

dubbo结合nacos以及springboot的试例项目

环境要求：jave8 maven nacos 

启动顺序：nacos -> provider -> consumer

nacos启动命令：startup.cmd -m standalone

## 模块说明
consumer：消费者  
interface：接口定义  
provider：服务提供者(接口实现方)  
provider-other：服务提供者(接口实现方) 

## 接口测试
```
//sayhello接口实现提供来自provider
http://127.0.0.1:8052/sayhello1?name=JAY

//sayhello接口实现提供来自provider-other
http://127.0.0.1:8052/sayhello2?name=JAY

//读取customerName配置 来自dubbo.properties
http://127.0.0.1:8052/getconfig1

//读取customerName配置 来自springcloud-service-one.properties
http://127.0.0.1:8052/getconfig2
```

## Nacos作为外部配置

### dubbo外部配置
<img width="800" height="500" src="https://raw.githubusercontent.com/MroZ11/dubbo-nacos-spring-boot/main/dubboPropertiesInNacos.png"/>  

### spring外部配置  
<img width="800" height="500" src="https://raw.githubusercontent.com/MroZ11/dubbo-nacos-spring-boot/main/springPropertiesInNacos.png"/>
