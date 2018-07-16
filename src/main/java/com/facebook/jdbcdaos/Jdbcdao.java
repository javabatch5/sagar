package com.facebook.jdbcdaos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import com.facebook.daos.interfaces.Interfaces;
import com.facebook.dbutil.DbJdbcUtil.ConnectionFactory;
import com.pojos.Student;

public class Jdbcdao implements Interfaces {

	public void registerStd(Student std) throws Exception {
		System.out.println("Entered into registerStd :: StudentJdbcDao");
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement ps = connection.prepareStatement("insert into student1 values(?,?,?,?)");
		ps.setString(1, std.getName());
		ps.setString(2, std.getUname());
		ps.setString(3, std.getPwrd());
		ps.setString(4, std.getMnumber());
		int rs = ps.executeUpdate();
		System.out.println("Exit from registerStd :: StudentJdbcDao");
		return;
	}

	public List<Student> loginStd(Student std) throws Exception {
		System.out.println("Entered into loginStd :: StudentJdbcDao");
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement ps = connection.prepareStatement("select * from student1 where uname = ? AND pwrd = ?");
		ps.setString(1, std.getUname());
		ps.setString(2, std.getPwrd());
		ResultSet rs = ps.executeQuery();
		List<Student> stdList = new ArrayList<Student>();
		while (rs.next()) {
			Student student = new Student();
			student.setUname(rs.getString("uname"));
			student.setName(rs.getString("name"));
			student.setMnumber(rs.getString("mnumber"));
			student.setPwrd(rs.getString("pwrd"));
			stdList.add(student);
		}
		System.out.println("Exit from loginStd :: StudentJdbcDao");
		return stdList;
	}

	public List<Student> getAllStudents() throws Exception {
		System.out.println("Entered into getAllStudnts :: StudentJdbcDao");
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement ps = connection.prepareStatement("select * from student1");

		ResultSet rs = ps.executeQuery();
		List<Student> stdList = new ArrayList<Student>();
		while (rs.next()) {
			Student student = new Student();
			student.setUname(rs.getString("uname"));
			student.setName(rs.getString("name"));
			student.setMnumber(rs.getString("mnumber"));
			student.setPwrd(rs.getString("pwrd"));
			stdList.add(student);
		}
		System.out.println("Exit from getAllStudents :: StudentJdbcDao");
		return stdList;
	}

	public void deleteStd(String uname) throws Exception {
		System.out.println("Entered into deleteStd :: JdbcDao");
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement ps = connection.prepareStatement("delete from student1 where uname=?");
		ps.setString(1, uname);
		int result = ps.executeUpdate();
		System.out.println("Exit from deleteStd :: StudentJdbcDao");
		return;
	}

	public List<Student> editStd(String uname) throws Exception {
		System.out.println("Entered into editStd :: JdbcDao");
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement ps = connection.prepareStatement("select * from student1 where uname=?");

		ps.setString(1,uname);
		ResultSet rs = ps.executeQuery();
		List<Student> stdList = new ArrayList<Student>();
		while (rs.next()) {
			Student student = new Student();
			student.setUname(rs.getString("uname"));
			student.setName(rs.getString("name"));
			student.setMnumber(rs.getString("mnumber"));
			student.setPwrd(rs.getString("pwrd"));
			stdList.add(student);
		}
		System.out.println("Exit from getAllStudents :: StudentJdbcDao");
		return stdList;
	}

	public void update(Student std) throws Exception {
		System.out.println("Entered into updateStd :: JdbcDao");
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement ps = connection.prepareStatement("update student1 set name=?, pwrd=?, mnumber=? where uname=?");
		ps.setString(1, std.getName());
		ps.setString(2, std.getPwrd());
		ps.setString(3, std.getMnumber());
		ps.setString(4, std.getUname());
		int rs = ps.executeUpdate();
		System.out.println("Exit from updateStd :: StudentJdbcDao");
		
	}

	public void deleteAll(List<String> uname) throws Exception {
		System.out.println("Entered into updateStd :: JdbcDao");
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = ConnectionFactory.getConnection();

		for (String string : uname) {
			PreparedStatement ps = connection.prepareStatement("delete from student1 where uname=?");
			ps.setString(1, string);
			int rs = ps.executeUpdate();
			System.out.println("Exit from deleteAllStd :: StudentJdbcDao");
		}
	}

}