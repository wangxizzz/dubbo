## 项目说明：
**首先，这是一个spring工程。**  

- 实现同步获取User对象。在provider端阻塞4s,同样在consumer端照样阻塞4s，在这4s内无法执行下面的逻辑
- 通过Guava中的ListeningFuture操作dubbo的异步，失败。因为ListeningFuture没有实现Serializable。JDK的CompletableFuture也是一样的错误。
- 通过dubbo自己的异步处理获取User对象。。。等待完成中。。。