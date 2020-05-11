package com.demo.bootuserserviceconsumer.service.impl;

import java.util.Arrays;
import java.util.List;

import com.demo.bean.UserAddress;
import com.demo.service.OrderService;
import com.demo.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;


/**
 * 1、将服务提供者注册到注册中心（暴露服务）
 * 		1）、导入dubbo依赖（2.6.2）\操作zookeeper的客户端(curator)
 * 		2）、配置服务提供者
 * 
 * 2、让服务消费者去注册中心订阅服务提供者的服务地址
 *
 */
@Service
public class OrderServiceImpl implements OrderService {

	//@Autowired
	// 远程引用服务，基于注解的形式引用
    // @Reference(url = "127.0.0.1:20880")   //dubbo直连,直接输入服务提供方的地址，不启动注册中心
	@Reference(loadbalance="random",timeout=1000)  // 负载均衡策略
	private UserService userService;

	//@HystrixCommand(fallbackMethod="hello")
	@Override
	public List<UserAddress> initOrder(String userId) {
		//1、查询用户的收货地址
		List<UserAddress> addressList = userService.getUserAddressList(userId);
		return addressList;
	}
	
	
	public List<UserAddress> hello(String userId) {
		return Arrays.asList(new UserAddress(10, "测试地址", "1", "测试", "测试", "Y"));
	}
	

}
