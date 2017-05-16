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
 * Servlet implementation class CustomerSearch
 */
@WebServlet("/CustomerSearch")
public class CustomerSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerSearch() {
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
			request.setAttribute("name", user);
			RequestDispatcher view = request.getRequestDispatcher("customerSearch.jsp");
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
		if("test".equals(user)){
			String name = request.getParameter("name");
			String cellphone = request.getParameter("cellphone");
			Database database = new Database();
			String[] data = database.DBSearch(name, cellphone);
			if(data[0] != null){
				System.out.println("id: " + data[0]);
				request.setAttribute("DBdata", data);
				request.setAttribute("name", user);
				RequestDispatcher view = request.getRequestDispatcher("searchResult.jsp");
				view.forward(request, response);
			}
			else{
				request.setAttribute("name", user);
				RequestDispatcher view = request.getRequestDispatcher("searchNothing.jsp");
				view.forward(request, response);
				//response.sendRedirect("/ServletLearning/searchNothing.jsp");
			}
		}
		else{
			response.sendRedirect("/ServletLearning/login.jsp");
		}
	}

}
