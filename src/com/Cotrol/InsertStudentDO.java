package com.Cotrol;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbdao.InsertStudentDBO;
import com.model.StudentBean;

public class InsertStudentDO extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public InsertStudentDO() {
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
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8;pageEncoding=UTF-8");
		String sno = request.getParameter("sno");
		String name = request.getParameter("name");
		String classes = request.getParameter("classes");
		StudentBean studentBean = new StudentBean();
		studentBean.setSno(sno);
		studentBean.setName(name);
		studentBean.setClasses(classes);
		InsertStudentDBO insertStudentDBO = new InsertStudentDBO();
		String rst = insertStudentDBO.setinfo(studentBean);
		if (rst.equals("1")) {
			// 插入成功
			String url = "InsertStudent.jsp?error=0";
			response.sendRedirect(url);
		} else {
			// 插入失败已存在此学生
			String url = "InsertStudent.jsp?error=1";
			response.sendRedirect(url);
		}
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
