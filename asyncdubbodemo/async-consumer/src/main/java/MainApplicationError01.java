import bean.User;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.impl.UserServiceConsumer;

import java.util.concurrent.ExecutionException;

/**
 * 无法再dubbo中利用ListeningFuture或CompletableFuture实现异步，
 * 因为ListeningFutureTask或CompletableFutureTask都没有实现Serializable接口。
 * 因此需要利用dubbo自己的异步实现
 */
public class MainApplicationError01 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("consumer.xml");
        UserServiceConsumer userServiceConsumer = (UserServiceConsumer) ioc.getBean("userServiceConsumer");
        System.out.println("进入MainApplicationAsync01。。。。。。");
        ListenableFuture<User> userListenableFuture = userServiceConsumer.getUserInConsumerByGuavaAsync();
        userListenableFuture.addListener(() -> {
            try {
                System.out.println(userListenableFuture.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }, MoreExecutors.directExecutor());

        System.out.println("上面的方法在异步调用中，程序依然往下走。。。。");

        System.out.println("执行其他逻辑中。。。。" + "s");
    }
}
