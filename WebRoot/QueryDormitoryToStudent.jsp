<%@page import="com.model.StudentBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<% 
String error=request.getParameter("error");
List<StudentBean> list =(ArrayList)request.getAttribute("list");
if(error!=null&&error.equals("1")){
	error="查询失败!无此寝室";
}else{
	error="";
}
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	  <meta charset="utf-8" />
	  <!--此处的meta标签声明的是该网页的作者以及所编写网站使用的软件；
	此处也可以声明网站内容以及网站的关键词；-->
	  <meta name="寝室学生管理系统" content="Atom" />
	  <title>DSMS | 寝室学生管理系统</title>
	  <!--以下代码表示网页标题处的图片-->
	  <link href="PHOTO/Title Image.png" rel="shortcut icon" />
	  <!--以下所有link标签均是链接本网站的css样式-->
	 <link rel="stylesheet" type="text/css" href="DSMS_css/background.css" />
	 <link rel="stylesheet" type="text/css" href="DSMS_css/list.css" />
  	  <link rel="stylesheet" type="text/css" href="DSMS_css/table.css"/>
    	
    

  </head>
  
  <body>
  <div class="whole">
      <div class="header_photo">
        <img src="PHOTO/Header Image.png" alt="首页顶部图片" title="首页顶部图片"/>
      </div>
      <div class="middle">
        <div class="left_menu">
          <div class="left_top_menu">
            <ul id="update">
              <li id="gengxin">更新</li>
              <li id="stay_in"><a href="DSMS_one1.html"><p class="z">入住</p></a></li>
              <li id="points"><a href="DSMS_one2.html"><p class="z">扣分</p></a></li>
              <li id="student"><a href="DSMS_one3.html"><p class="z">学生</p></a></li>
            </ul>
          </div>
          <div class="left_bottom_menu">
            <ul id="inquire">
              <li id="chaxun">查询</li>
              <li id="student_id"><a href="DSMS_one4.html"><p class="z">学生</p></a></li>
              <li id="dormitory"><a href="DSMS_one5.html"><p class="z">寝室</p></a></li>
            </ul>
          </div>
        </div>
        <div class="middle_view">
        	<div class="middle_table">
            <h1><%=error %></h1>
              	<!-- Table -->
              	<%if(list!=null){%>
              	    <table id="studentTable">
                      <tr>
                      	<th>学号</th>
                      	<th>姓名</th>
                      	<th>班级</th>
                      	<th>床位号</th>
                      </tr>
              	<%for(StudentBean studentBean:list){%>
            			  	 <tr>
            			  	 <td><%=studentBean.getSno()%></td>
            			  	 <td><%=studentBean.getName()%></td>
            			  	 <td><%=studentBean.getClasses()%></td>
            			  	 <td><%=studentBean.getBno()%></td>
            			  	 </tr>
              	 <%
              	 	}
              	 		}
              	  %>
              	  <!-- TableEnd -->
              	  </table>
            </div>
        </div>
      </div>
      <div class="footer">
      </div>
    </div>
  </body>
</html>
