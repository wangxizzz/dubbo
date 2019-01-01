package service.impl;

import bean.User;
import com.google.common.util.concurrent.ListenableFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.UserService;

import java.util.concurrent.CompletableFuture;

@Service(value = "userServiceConsumer")
public class UserServiceConsumer {
    @Autowired
    private UserService userService;

    public User getUserInConsumer() {

        return userService.getUser();
    }

    public ListenableFuture<User> getUserInConsumerByGuavaAsync() {

        return userService.getUserByGuavaAsync();
    }

}