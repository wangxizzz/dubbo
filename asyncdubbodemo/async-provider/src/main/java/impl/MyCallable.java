package impl;

import bean.User;

import java.io.Serializable;
import java.util.concurrent.Callable;

/**
 * <Description>
 *
 * @author wangxi
 */
public class MyCallable implements Callable, Serializable {
    @Override
    public User call() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        User user = new User(1,"aa");
        return user;
    }
}

