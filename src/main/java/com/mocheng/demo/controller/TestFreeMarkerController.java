package com.mocheng.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 测试freeMarker模版使用
 * @author liushuo
 *
 */
@Controller
public class TestFreeMarkerController {
	
	/**
	 * 
	 * @return ModelAndView
	 */
	@RequestMapping("/index")
	public ModelAndView index() {
		//使用modelAndView
		ModelAndView model=new ModelAndView("index");
		model.addObject("message", "hello index");
		return model;
	}
	
	/**
	 * 
	 * @param map
	 * @return string
	 */
	@RequestMapping("/index2")
	public String  index2(ModelMap map) {
		//使用ModelMap
		map.addAttribute("message", "hello index2");
		return "index";
	}
	
	/**
	 * 
	 * @param req
	 * @return
	 */
	@RequestMapping("/index3")
	public String  index2(HttpServletRequest req) {
		//使用request
		req.setAttribute("message", "hello index3");
		return "index";
	}
	
	/**
	 * 测试freemarker 遍历
	 * @param req
	 * @return
	 */
	@RequestMapping("/index4")
	public String  index4(HttpServletRequest req) {
		List<String> list= new ArrayList<>();
		list.add("张3");
		list.add("张4");
		list.add("张5");
		list.add("张6");
		//使用request
		req.setAttribute("studentList", list);
		return "indexList";
	}
	
	
	
	
	
}
