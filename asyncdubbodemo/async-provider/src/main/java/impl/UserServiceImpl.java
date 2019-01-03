package impl;

import bean.User;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import service.UserService;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UserServiceImpl implements UserService {

    /**
     * 同步调用getUser
     *
     * @return User
     */
    @Override    // 服务的暴露写在provider.xml中
    public User getUser() {
        System.out.println("进入provider.getUser..........");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new User(1, "aa");
    }

    /**
     * 异步调用ListenableFuture
     *
     * @return ListenableFuture<User>
     */
    @Override
    public ListenableFuture<User> getUserByGuavaAsync() {
        System.out.println("aaaaaa");
        ExecutorService service = Executors.newFixedThreadPool(4);
        ListeningExecutorService listeningExecutorService = MoreExecutors.listeningDecorator(service);
        ListenableFuture<User> submit = listeningExecutorService.submit(() -> {
            // 创建User很耗时
            Thread.sleep(5000);

            return new User(2, "22222222");
        });
        service.shutdown();
        listeningExecutorService.shutdown();
        System.out.println("bbbbbbbbb");
        return submit;
    }

    @Override
    public User getUserByDubboAsync() {

        try {
            System.out.println("创建User很耗时间......");
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new User(333333, "dubbo的异步实现");
    }
}
