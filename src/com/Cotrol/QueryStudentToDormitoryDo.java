package com.Cotrol;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import com.dbdao.QueryStudentToDormitoryDBO;
import com.model.Dormitory;

// 通过学号查询寝室信息，床号
public class QueryStudentToDormitoryDo extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public QueryStudentToDormitoryDo() {
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
		QueryStudentToDormitoryDBO qstd = new QueryStudentToDormitoryDBO();
		String sno = request.getParameter("sno");
		List<Dormitory> list = qstd.getInfo(0, sno);
		if (!list.isEmpty()) {
			Dormitory dormitory = list.get(0);
			String name = URLEncoder.encode(dormitory.getName(), "utf-8");
			String url = "QueryStudentToDormitory.jsp?cno="
					+ dormitory.getCno() + "&bno=" + dormitory.getBno()
					+ "&maxpeo=" + dormitory.getMaxpeo() + "&peo="
					+ dormitory.getPeo()+"&sno="+sno+"&name="+name+
					"&error=0";
			// url=new String(url.getBytes("GBK"),"ISO8859_1");
			response.sendRedirect(url);
		} else {
			// 无此学生
			String url = "QueryStudentToDormitory.jsp?error=1";
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
