package com.Cotrol;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.ManagedBean;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbdao.InsertManagementDBO;
import com.model.ManagementBean;

public class InsertManagementDO extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public InsertManagementDO() {
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
		String num = request.getParameter("num");
		Date dt = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd");
		String stringDate = dateFormat.format(dt);
		ManagementBean managementBean = new ManagementBean();
		managementBean.setSno(sno);
		managementBean.setNum(num);
		managementBean.setDate(stringDate);
		String rt = new InsertManagementDBO().insert(managementBean);
		if (rt.equals("-1")) {
			// 插入失败
			String url = "insertManagement.jsp?error=1";
			response.sendRedirect(url);
		} else if (rt.equals("1")) {
			// 插入成功
			String url = "insertManagement.jsp?error=0";
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
