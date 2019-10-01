import bean.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.impl.UserServiceConsumer;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * 测试返回Future,测试失败，还是存在序列化问题。
 */
public class MainApplicationByFuture {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("consumer.xml");
        UserServiceConsumer userServiceConsumer = (UserServiceConsumer) ioc.getBean("userServiceConsumer");
        Future<User> future = userServiceConsumer.getUserByFuture();

        System.out.println("===================执行其他逻辑。。。。。。");
        System.out.println("===================执行其他逻辑。。。。。。");
        System.out.println("===================执行其他逻辑。。。。。。");
        System.out.println("===================执行其他逻辑。。。。。。");

        System.out.println("获取结果。。。");
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
