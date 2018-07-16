package com.facebook.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.facebook.daos.Hiberdao;
import com.facebook.daos.interfaces.Interfaces;
import com.facebook.jdbcdaos.Jdbcdao;
import com.facebook.validation.Validation;
import com.pojos.Student;

public class Service {
	@Autowired
	private Interfaces dao;

	public String registerStd(Student std) throws Exception {
		System.out.println(std.getName());
		System.out.println(std.getUname());
		System.out.println(std.getPwrd());
		System.out.println(std.getMnumber());
		Validation validation = new Validation();
		if (validation.nullcheck(std.getUname())) {

			return "register";
		}
		dao.registerStd(std);
		// Hiberdao hiberdao = new Hiberdao();
		// hiberdao.registerStd(std);
		return "login";
	}

	public String loginStd(Student std, Model model) throws Exception {
		System.out.println("Entered into loginStd :: StudentService");
		System.out.println(std.getUname());
		System.out.println(std.getPwrd());

		// Validation logic
		Validation validation = new Validation();
		if (validation.nullcheck(std.getUname()) || validation.nullcheck(std.getPwrd())) {
			model.addAttribute("message", "Username and password should not be empty or null");
			return "login";

		}
		// fetch data for mail and password
		// Hiberdao dao = new Hiberdao();

		// Jdbcdao jdbcdao = new Jdbcdao();
		List<Student> list = dao.loginStd(std);

		// validate list
		if (list.isEmpty()) {
			model.addAttribute("message", "Invalid Credentials!! Please try again");
			return "login";
		}

		// get all employees
		List<Student> stdlist = dao.getAllStudents();

		for (Student student : stdlist) {

		}
		model.addAttribute("stdList", stdlist);

		model.addAttribute("userName", std.getUname());
		return "profile";

	}

	public String deleteStd(@RequestParam("uname") String uname, Model model) throws Exception {
		dao.deleteStd(uname);

		// get all students
		List<Student> stdlist = dao.getAllStudents();

		model.addAttribute("stdList", stdlist);
		return "profile";
	}

	public String editStd(@RequestParam("name") String uname, Model model) throws Exception {
		List<Student> list = dao.editStd(uname);
		// get all students
		//List<Student> stdlist = dao.getAllStudents();

		model.addAttribute("student", list.get(0));
		return "edit";

	}
	public String update(Student std, Model model) throws Exception {
		dao.update(std);
		List<Student> stdlist = dao.getAllStudents();
		model.addAttribute("stdList", stdlist);
		return "profile";
		
	}
	public String deleteALL(@RequestParam("deletemultiple") List<String> uname, Model model)throws Exception{
		dao.deleteAll(uname);
		List<Student> stdlist = dao.getAllStudents();
		model.addAttribute("stdList", stdlist);
		return "profile";
		
	}
	
}
