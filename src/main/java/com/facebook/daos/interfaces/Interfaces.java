package com.facebook.daos.interfaces;

import java.sql.SQLException;
import java.util.List;

import org.springframework.ui.Model;

import com.pojos.Student;

public interface Interfaces  {
	public void registerStd(Student std) throws Exception;
	public List<Student> loginStd(Student std) throws Exception; 
	public List<Student> getAllStudents() throws Exception ;
	public void deleteStd(String uname)throws Exception;
	public List<Student> editStd(String uname)throws Exception;
	public void update(Student std)throws Exception;
	public void deleteAll(List<String> uname)throws Exception;
	
	

}