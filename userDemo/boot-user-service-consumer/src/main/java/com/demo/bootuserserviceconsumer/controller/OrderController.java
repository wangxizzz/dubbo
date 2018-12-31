package com.demo.bootuserserviceconsumer.controller;

import java.util.List;

import com.demo.bean.UserAddress;
import com.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class OrderController {
	
	@Autowired
	private OrderService orderService;

	/**
	 * 返回订单的初始化信息
     *
	 * @param userId 用户id
	 * @return 返回订单信息
	 */
	@ResponseBody
	@RequestMapping("/initOrder")
	public List<UserAddress> initOrder(@RequestParam("uid")String userId) {
		return orderService.initOrder(userId);
	}

}
