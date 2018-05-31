package com.mocheng.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mocheng.demo.model.StudentModel;
import com.mocheng.demo.service.TestService;

@Controller
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
		System.out.println("执行完成");
	}
	@RequestMapping("/list")
	public String getList(HttpServletRequest req) {
		List<StudentModel> list = testService.getList();
		req.setAttribute("studentList", list);
		return "studentList";
	}
	
}
