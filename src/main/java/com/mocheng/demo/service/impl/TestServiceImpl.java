package com.mocheng.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mocheng.demo.mapper.TestMapper;
import com.mocheng.demo.service.TestService;

@Service
public class TestServiceImpl implements TestService {
	
	@Autowired
	private TestMapper testMapper;
	
	public void TestMybatis() {
		testMapper.addStudent();
	};
	
	
	
}
