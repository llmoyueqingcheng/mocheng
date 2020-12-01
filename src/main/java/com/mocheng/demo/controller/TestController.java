package com.mocheng.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mocheng.demo.service.TestService;

@RestController
public class TestController {
	
	@Autowired
	private TestService testService;
	@RequestMapping("/hello")
	public String Hello() {
		System.out.println("111");
		return "zzz";
	}
	@RequestMapping("/add")
	public void testMabatis() {
		testService.TestMybatis();
		//修改开发分支22
		System.out.println("执行完成");
	}
}
