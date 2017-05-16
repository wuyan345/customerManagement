package com.test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CustomerQuery
 */
@WebServlet("/CustomerQuery")
public class CustomerQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerQuery() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		String user = (String)session.getAttribute("user");
		//System.out.println("user: " + user);
		if("test".equals(user)){
			Database database = new Database();
			String[][] data = database.DBReadData();
			int rows = data.length;
			request.setAttribute("rows", rows);
			request.setAttribute("DBdata", data);
			request.setAttribute("name", user);
			//System.out.println(data[0][0]);
			RequestDispatcher view = request.getRequestDispatcher("customerQuery.jsp");
			view.forward(request, response);
		}
		else{
			response.sendRedirect("/ServletLearning/login.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
