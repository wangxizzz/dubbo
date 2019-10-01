package service;

import bean.User;
import com.google.common.util.concurrent.ListenableFuture;

import java.util.concurrent.Future;


public interface UserService {
    /**
     * 同步获取User对象
     *
     * @return 返回User对象
     */
    User getUser();

    /**
     * 测试返回Future，测试失败
     * @return
     */
    public Future<User> getUserByFuture();

    /**
     * 通过guava中的ListenableFuture，
     * ListenableFutureTask并没有实现Serializable
     * CompletableFutureTask也没有实现序列化
     *  这种实现会报错，无法实现在dubbo中的异步，需要使用dubbo自己的异步
     * @return  User对象
     */
    ListenableFuture<User> getUserByGuavaAsync();

    /**
     *  通过dubbo的异步实现多服务调用的异步执行
     *
     * @return 返回User
     */
    User getUserByDubboAsync();
}
