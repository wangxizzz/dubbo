import bean.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.impl.UserServiceConsumer;

import java.util.concurrent.*;

/**
 * 测试同步调用getUserInConsumer()方法
 */
public class MainApplication {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("consumer.xml");
        UserServiceConsumer userServiceConsumer = (UserServiceConsumer) ioc.getBean("userServiceConsumer");
        // 同步调用
        //User user = userServiceConsumer.getUserInConsumer();

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Future<User> future = executorService.submit(() -> {
            return userServiceConsumer.getUserInConsumer();
        });


        System.out.println("===================执行其他逻辑。。。。。。");
        System.out.println("===================执行其他逻辑。。。。。。");
        System.out.println("===================执行其他逻辑。。。。。。");

        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
