package com.org.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.UserDao;
import com.org.dto.User;
@WebServlet("/register")
public class RegisterServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name =request.getParameter("name");
		String age =request.getParameter("age");
		String mobile =request.getParameter("mobile");
		String email =request.getParameter("email");
		String password=request.getParameter("password");
		int age1=Integer.parseInt(age);
		long mobile1=Long.parseLong(mobile);
		
		User user=new User();
		user.setName(name);
		user.setAge(age1);
		user.setMobile(mobile1);
		user.setEmail(email);
		user.setPassword(password);
		
		UserDao uDao=new UserDao();
		uDao.saveUser(user);
		
		HttpSession session=request.getSession();
		session.setAttribute("success","Registration Successful");
		
		response.sendRedirect("register.jsp");
		
	}
}