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
 * Servlet implementation class CustomersSystem
 */
@WebServlet("/CustomersSystem")
public class CustomersSystem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomersSystem() {
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
		if("test".equals(user)){
			request.setAttribute("name", user);
			RequestDispatcher view = request.getRequestDispatcher("index.jsp");
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
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String user = (String)session.getAttribute("user");
		//System.out.println("user: " + user);
		if("test".equals(user)){
			String name = request.getParameter("name");
			String gender = request.getParameter("gender");
			String birthday = request.getParameter("birthday");
			String address = request.getParameter("address");
			String email = request.getParameter("email");
			String cellphone = request.getParameter("cellphone");
			String description = request.getParameter("description");
			//System.out.println(name);
			if(!name.isEmpty()){
				Database database = new Database();
				database.DBWriteData(name, gender, birthday, address, email, cellphone, description);
			}
			//Database database = new Database();
			//database.DBReadData();
			response.sendRedirect("/ServletLearning/index.jsp");
		}
		else{
			response.sendRedirect("/ServletLearning/login.jsp");
		}
	}

}
