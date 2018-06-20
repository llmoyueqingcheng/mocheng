package com.mocheng.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.ansj.domain.Result;
import org.ansj.domain.Term;
import org.ansj.library.UserDefineLibrary;
import org.ansj.splitWord.analysis.NlpAnalysis;
import org.ansj.splitWord.analysis.ToAnalysis;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mocheng.demo.model.StudentModel;
import com.mocheng.demo.service.TestService;

@Controller
public class TestController {
    private static final Logger logger= LoggerFactory.getLogger(TestController.class);

	@Autowired
	private TestService testService;
	@RequestMapping("/add")
	public void testMabatis() {
		testService.TestMybatis();
		logger.info("执行完成");
	}
	@RequestMapping("/list")
	public String getList(HttpServletRequest req) {
		List<StudentModel> list = testService.getList();
		req.setAttribute("studentList", list);
		return "studentList";
	}
	@RequestMapping("/excelImport")
	public String excelImport(HttpServletRequest req) {
		return "excelImport";
	}
	@RequestMapping("/testAnsj")
	@ResponseBody
	public String testAnsj(HttpServletRequest req) {
		 // 增加新词,中间按照'\t'隔开
        UserDefineLibrary.insertWord("ansj中文分词", "userDefine", 1000);
        
        List<Term> terms = ToAnalysis.parse("我觉得Ansj中文分词是一个不错的系统!我是王婆!").getTerms();
        System.out.println("增加新词例子:" + terms);
        // 删除词语,只能删除.用户自定义的词典.
        UserDefineLibrary.removeWord("ansj中文分词");
        terms = ToAnalysis.parse("我觉得ansj中文分词是一个不错的系统!我是王婆!").getTerms();
        System.out.println("删除用户自定义词典例子:" + terms);
        return "";
	}
	
	@RequestMapping("/websocket")
	public String go() {
		return "websocket";
	}
	
	
}
