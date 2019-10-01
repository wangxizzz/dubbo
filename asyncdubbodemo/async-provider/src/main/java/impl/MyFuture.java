package impl;

import bean.User;

import java.io.Serializable;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * <Description>
 *
 * @author wangxi
 */
public class MyFuture<T> extends FutureTask<T> implements Serializable {
    public MyFuture(Callable c) {
        super(c);
    }
}

