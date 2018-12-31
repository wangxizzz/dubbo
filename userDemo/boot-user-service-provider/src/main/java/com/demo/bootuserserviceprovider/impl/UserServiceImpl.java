package com.demo.bootuserserviceprovider.impl;

import java.util.Arrays;
import java.util.List;

import com.alibaba.dubbo.config.annotation.Service;
import com.demo.bean.UserAddress;
import com.demo.service.UserService;
import org.springframework.stereotype.Component;



@Service   //暴露服务，基于注解的暴露服务写法
@Component  // spring的Service改为Component区分
public class UserServiceImpl implements UserService {

	//@HystrixCommand
	@Override
	public List<UserAddress> getUserAddressList(String userId) {
		System.out.println("UserServiceImpl..3.....");
		UserAddress address1 = new UserAddress(1, "北京市昌平区层", "1", "李老师", "010-56253825", "Y");
		UserAddress address2 = new UserAddress(2, "深圳市", "1", "王老师", "010-56253825", "N");
		if(Math.random()>0.5) {
			throw new RuntimeException();
		}
		return Arrays.asList(address1,address2);
	}

}
