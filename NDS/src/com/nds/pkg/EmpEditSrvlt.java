package com.nds.pkg;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmpEditSrvlt
 */
@WebServlet("/EmpEditSrvlt")
public class EmpEditSrvlt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpEditSrvlt() {
        super();
        // TODO Auto-generated constructor stub
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
		String e = request.getParameter("edit");
		if(e.equals("Edit User Info")){
			request.setAttribute("uName", request.getParameter("uName"));
			request.setAttribute("pass", request.getParameter("pass"));
			request.setAttribute("email", request.getParameter("email"));
		}
		else{
			
		}
		request.getRequestDispatcher("/EmployeeEdit.jsp").forward(request, response);
	}
}
