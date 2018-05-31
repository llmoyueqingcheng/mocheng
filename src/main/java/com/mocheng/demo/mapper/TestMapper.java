package com.mocheng.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mocheng.demo.model.StudentModel;

@Mapper
public interface TestMapper {

	void addStudent();

	List<StudentModel> getList();

}
