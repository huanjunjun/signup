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
			//��ȡ����
			
			user user1=new user();
			user1.setUsernameString(usernameString);
			user1.setPasswordString(passwordString);
			//��װ����
			
			usermodel umodel=new usermodel();
			boolean flag =umodel.login(user1);
			//��������
			
			if(flag  == false )
			{
				//��½ʧ��
				request.setAttribute("msg", "�û������������");
				//����ת��
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
			else {
				//�ɹ�
				//��¼�ɹ�����
				
				response.sendRedirect("/signup/success.jsp");
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new RuntimeException();
		}
		
		//ҳ����ת
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
