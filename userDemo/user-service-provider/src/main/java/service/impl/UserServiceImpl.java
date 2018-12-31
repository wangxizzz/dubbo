package service.impl;

import com.demo.bean.UserAddress;
import com.demo.service.UserService;

import java.util.Arrays;
import java.util.List;


public class UserServiceImpl implements UserService {

	@Override
	public List<UserAddress> getUserAddressList(String userId) {
		System.out.println("UserServiceImpl.....old...");
		UserAddress address1 = new UserAddress(1, "北京市昌平", "1", "李老师", "010-56253825", "Y");
		UserAddress address2 = new UserAddress(2, "深圳市宝安", "1", "王老师", "010-56253825", "N");
		return Arrays.asList(address1,address2);
	}

}
