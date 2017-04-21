package com.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

import com.bean.Employee;
import com.dao.EmployeeDao;
@Controller
public class EmployeeController {
@Autowired
EmployeeDao dao;



@RequestMapping("/reg")  
public ModelAndView registration(){  
    return new ModelAndView("reg","command",new Employee());  
}  

@RequestMapping("/search")  
public ModelAndView retriev(){  
    return new ModelAndView("search","command",new Employee());  
}  

@RequestMapping(value="/insert")  
public ModelAndView save(@ModelAttribute("st") Employee st) throws Exception{  
	System.out.println(st.getId()+""+st.getName());
    dao.saveEmployee(st);  
    return new ModelAndView("redirect:/sucess");
}
@RequestMapping("/retrieve")  
public ModelAndView search(@ModelAttribute("st") Employee st) throws Exception{  
	
    Employee e=dao.getById(st.getId()); 
    List<Employee> list=new ArrayList<Employee>();
    list.add(e);
    
    return new ModelAndView("search1","list",list);
    
}
@RequestMapping("/sucess")
public ModelAndView sucessPage() {

	String message = "sucessfully data inserted";
	return new ModelAndView("sucess", "message", message);
}
@RequestMapping("/search1")
public ModelAndView sucessearch() {
String name="";
	return new ModelAndView("search1", "name",name);
}
}
