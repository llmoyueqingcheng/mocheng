package com.mocheng.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mocheng.demo.mapper.TestMapper;
import com.mocheng.demo.model.StudentModel;
import com.mocheng.demo.service.TestService;

@Service
public class TestServiceImpl implements TestService {
	
	@Autowired
	private TestMapper testMapper;
	
	public void TestMybatis() {
		testMapper.addStudent();
	}

	@Override
	public List<StudentModel> getList() {
		List<StudentModel> lsit=testMapper.getList();
		return lsit;
	};
	
	
	
}
