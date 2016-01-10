package com.Cotrol;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbdao.QueryDormitoryToStudentDBO;
import com.dbdao.SelectAllDBO;
import com.model.StudentBean;

public class SelectAllDO extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public SelectAllDO() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8;pageEncoding=UTF-8");
		SelectAllDBO selectAllDBO = new SelectAllDBO();
		List<StudentBean> list = selectAllDBO.getinfo();
		if (!list.isEmpty()) {
			// 返回List
			// for (StudentBean studentBean : list) {
			//
			// }
			// 转发
			request.setAttribute("list", list);
			request.getRequestDispatcher("selectAll.jsp").forward(request, response);
		} else {
			// 无信息
			String url = "selectAllDBO.jsp?error=1";
			response.sendRedirect(url);
		}

	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
