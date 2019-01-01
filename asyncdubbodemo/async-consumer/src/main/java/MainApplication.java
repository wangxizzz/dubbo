import bean.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.impl.UserServiceConsumer;

/**
 * 测试同步调用getUserInConsumer()方法
 */
public class MainApplication {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("consumer.xml");
        UserServiceConsumer userServiceConsumer = (UserServiceConsumer) ioc.getBean("userServiceConsumer");
        // 同步调用
        User user = userServiceConsumer.getUserInConsumer();
        System.out.println(user);

        System.out.println("===================执行其他逻辑。。。。。。");
    }
}
