package com.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.entities.Users;
import com.services.UserServices;

@Controller
@RequestMapping(value="users")
public class UserController {

	UserServices userService;
	
	@RequestMapping(value="/page", method = RequestMethod.GET)
	public ModelAndView getPage()
	{
		ModelAndView view = new ModelAndView("hello");
		return view;
		
	}

	@RequestMapping(value="/saveOrUpdate", method= RequestMethod.POST)
	public @ResponseBody Map<String, Object> getSave(Users users){
		Map<String, Object> map = new HashMap<String, Object>();
		
		if(userService.saveOrUpdate(users)) {
			map.put("status", "200");
			map.put("message", "Saved Successfully") ;
		}
		return map;
	}
	
	@RequestMapping(value="/list", method = RequestMethod.POST)
	public @ResponseBody Map<String, Object> getAll(Users users){
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<Users> list = userService.list();
		
		if(list != null) {
			map.put("Status", "200");
			map.put("message", "Data Found");
			map.put("date", list);
		} else {
			map.put("status", "404");
			map.put("message", "Data not found");
		}
		return map;
	}
	
	@RequestMapping(value="/delete", method= RequestMethod.POST)
	public @ResponseBody Map<String, Object> delete(Users users){
		Map<String, Object> map = new HashMap<String, Object>();
		
		if(userService.delete(users)) {
			map.put("status", "200");
			map.put("message", "Delete successfully");
		}
		return map;
	}
}
