package com.test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SystemLogin
 */
@WebServlet("/SystemLogin")
public class SystemLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SystemLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		if("logout".equals(action)){
			session.removeAttribute("user");
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
		String id = request.getParameter("ID");
		String password = request.getParameter("password");
		if(id.equals("test") && password.equals("123456")){
			session.setAttribute("user", id);
			//session.removeAttribute("user");
			//Cookie cookie = new Cookie("id", "test");
			//cookie.setMaxAge(12*60*60);	// 12 hours
			//response.addCookie(cookie);
			//if(session.isNew())
			//	System.out.println("A new session");
			response.sendRedirect("/ServletLearning/CustomerQuery.do");
		}
		else{
			request.setAttribute("isLog", "NO");
			RequestDispatcher view = request.getRequestDispatcher("login.jsp");
			view.forward(request, response);
			//response.sendRedirect("/ServletLearning/login.jsp");
		}
	}

}
