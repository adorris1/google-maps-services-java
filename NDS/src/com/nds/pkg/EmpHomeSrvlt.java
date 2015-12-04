package com.nds.pkg;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import connections.user;

/**
 * Servlet implementation class EmpHomeSrvlt
 */
@WebServlet("/EmpHomeSrvlt")
public class EmpHomeSrvlt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpHomeSrvlt() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		user u = new user();
		request.setAttribute("uName", u.getUserName());
		request.setAttribute("hidPass", u.getHiddenPassword());
		request.setAttribute("pass", u.getPassword());
		request.setAttribute("company", u.getCompanyName());
		request.setAttribute("address", u.getAddressLn1());
		request.setAttribute("city", u.getCity());
		request.setAttribute("state", u.getState());
		request.setAttribute("zip", u.getZip());
		request.setAttribute("email", u.getEmail());
		request.setAttribute("csEmail", u.getCSEmail());
		request.setAttribute("csPhone", u.getCSPhone());
		request.setAttribute("path", u.getFilePath());
		u.closeUser();
		request.getRequestDispatcher("/EmployeeCenter.jsp").forward(request, response);
	}

}
