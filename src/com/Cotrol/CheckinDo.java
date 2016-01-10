package com.Cotrol;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbdao.CheckinDBO;
import com.model.CheckinBean;

public class CheckinDo extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CheckinDo() {
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
		// 学号
		String sno = request.getParameter("sno");
		// 寝室号
		String dno = request.getParameter("dno");
		// 床位号
		String bno = request.getParameter("bno");
		// 加入Bean
		CheckinBean checkinBean = new CheckinBean();
		checkinBean.setSno(sno);
		checkinBean.setDno(dno);
		checkinBean.setBno(bno);
		CheckinDBO checkinDBO = new CheckinDBO();
		String rt = checkinDBO.checkin(checkinBean);
		// 无此学生
		if (rt.equalsIgnoreCase("-1")) {
			String url = "checkin.jsp?error=1";
			response.sendRedirect(url);
		}
		// 无此宿舍或者人数已满
		else if (rt.equals("-2")) {
			String url = "checkin.jsp?error=2";
			response.sendRedirect(url);
		}
		//床位被占用
		else if (rt.equals("-3")) {
			String url = "checkin.jsp?error=3";
			response.sendRedirect(url);
		}
		//此学生以入住
		else if (rt.equals("-4")) {
			String url = "checkin.jsp?error=4";
			response.sendRedirect(url);
		}
		// 入住成功
		else {
			String url = "checkin.jsp?error=0";
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
