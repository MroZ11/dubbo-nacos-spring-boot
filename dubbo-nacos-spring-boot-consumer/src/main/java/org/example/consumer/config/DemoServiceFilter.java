package org.example.consumer.config;


import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;
import org.example.consumer.component.TeslComponent;


/**
 * 通过Filter对服务调用进行前置或后置处理
 */
@Activate
public class DemoServiceFilter implements Filter {

    private TeslComponent teslComponent;

    /**
     * 注意 这里需要通过set注入bean 像auth对象的传递就可以在这里做 不用写@Autowired dubbo会自动装配
     */
    public void setTeslComponent(TeslComponent teslComponent) {
        this.teslComponent = teslComponent;
    }

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        //用dubbo提供的ServiceBean即可获取bean，因为该类已经实现了ApplicationContextAware
        System.out.println(teslComponent.getTeslComponentName());
        invocation.setAttachment("sessionId", "code-77533");
        Result result = invoker.invoke(invocation);
        return result;
    }
}
