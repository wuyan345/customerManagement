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
 * Servlet implementation class CustomerEdit
 */
@WebServlet("/CustomerEdit")
public class CustomerEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerEdit() {
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
			Database database = new Database();
			String[][] data = database.DBReadData();
			String id = request.getParameter("id");
			int n = data.length;
			int row = 0;
			for(int i=0; i<n; i++){
				if(data[i][0].equals(id)){
					row = i;
					break;
				}
			}
			request.setAttribute("id", id);
			request.setAttribute("row", row);
			request.setAttribute("DBdata", data);
			request.setAttribute("name", user);
			RequestDispatcher view = request.getRequestDispatcher("customerEdit.jsp");
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
			String id = request.getParameter("id");
			String[] param = new String[7];
			param[0] = request.getParameter("name");
			param[1] = request.getParameter("gender");
			param[2] = request.getParameter("birthday");
			param[3] = request.getParameter("cellphone");
			param[4] = request.getParameter("address");
			param[5] = request.getParameter("email");
			param[6] = request.getParameter("description");
			Database database = new Database();
			database.DBUpdateData(id, param);
			
			response.sendRedirect("/ServletLearning/CustomerQuery.do");
		}
		else{
			response.sendRedirect("/ServletLearning/login.jsp");
		}
	}

}
