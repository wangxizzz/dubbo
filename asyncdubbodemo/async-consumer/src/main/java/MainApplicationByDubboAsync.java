import bean.User;
import com.alibaba.dubbo.rpc.RpcContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.impl.UserServiceConsumer;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author wxi.wang
 * 19-1-3
 */
public class MainApplicationByDubboAsync {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("consumer.xml");
        UserServiceConsumer userServiceConsumer = (UserServiceConsumer) ioc.getBean("userServiceConsumer");

        User user = userServiceConsumer.getUserInConsumerByDubboAsync();
        System.out.println("异步获取user:" + user);

        System.out.println("程序继续往下走......");

        Future<User> userFuture = RpcContext.getContext().getFuture();
        System.out.println("真正获取结果:" + userFuture.get());
    }
}
