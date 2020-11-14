package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.user;
import model.usermodel;

/**
 * Servlet implementation class loginservlet
 */
public class loginservlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		try {
			String usernameString=request.getParameter("username");
			String passwordString=request.getParameter("password");
			//获取数据
			
			user user1=new user();
			user1.setUsernameString(usernameString);
			user1.setPasswordString(passwordString);
			//封装数据
			
			usermodel umodel=new usermodel();
			boolean flag =umodel.login(user1);
			//处理数据
			
			if(flag  == false )
			{
				//登陆失败
				request.setAttribute("msg", "用户名或密码错误");
				//请求转发
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
			else {
				//成功
				//记录成功人数
				
				response.sendRedirect("/signup/success.jsp");
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new RuntimeException();
		}
		
		//页面跳转
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
