package com.nds.pkg;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import connections.user;
/**
 * Servlet implementation class LoginSrvlt
 */
public class LoginSrvlt extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginSrvlt() {
        super();
    }
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		user u = new user();
		String user = request.getParameter("name");
		String psw = request.getParameter("pass");
		
		if(psw.equals(u.getPassword())&&user.equalsIgnoreCase(u.getUserName())){
			u.closeUser();
			request.getRequestDispatcher("/EmployeeHome.jsp").forward(request, response);
		}
		else{
			request.setAttribute("errorMsg", "Invalid Credentials.");
			request.getRequestDispatcher("/Login.jsp").forward(request, response);
		}		
	}
}
