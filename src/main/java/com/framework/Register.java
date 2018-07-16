package com.framework;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.facebook.daos.Hiberdao;
import com.facebook.daos.interfaces.Interfaces;
import com.facebook.service.Service;
import com.pojos.Employee;
import com.pojos.Student;

@Controller

public class Register {
	@Autowired
	private Employee emp;
	@Autowired
	private Employee emp1;
	@Autowired
	private Service service;

	@RequestMapping(value = "/registerstd")
	public String registerStd(Student std) throws Exception {

		emp.setName("ajay");
		emp.setUname("ajay@gmail");
		emp.setPwrd("idontknow");
		emp.setMnumber("123456789");

		emp1.setName("vijay");
		emp1.setUname("vijay@gmail");
		emp1.setPwrd("dontaskme");
		emp1.setMnumber("123456789");
		System.out.println(emp.getName() + "  " + emp1.getName());
		// Service service = new Service();
		String result = service.registerStd(std);
		System.out.println("exiting form registerstd :: registerController");
		return result;
	}

	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginStd(Student std, Model model) throws Exception {
		String result = service.loginStd(std, model);
		return result;
	}

	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/deleteStudent")
	public String deleteStd(@RequestParam("uname") String uname, Model model) throws Exception {
		String result = service.deleteStd(uname, model);

		return result;
	}

	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/editStudent")
	public String editStd(@RequestParam("uname") String uname, Model model) throws Exception {
		String editStd = service.editStd(uname, model);

		return editStd;

	}

	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/update")
	public String update(Student std, Model model) throws Exception {

		String update = service.update(std, model);

		return update;
	}

	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/deleteall")
	public String deleteALL(@RequestParam("deletemultiple") List<String> uname, Model model)throws Exception {
		
		String deleteALL = service.deleteALL(uname, model);

		return deleteALL;
	}
}
