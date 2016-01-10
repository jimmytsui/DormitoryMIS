<%@page import="com.model.ManagementBean"%>
<%@page import="com.model.CheckinBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String error="";
	List<ManagementBean> list =(ArrayList) request.getAttribute("list");
 	if(list!=null&&list.size()==0){
 		error="无此学生或无扣分记录！";
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
  <noscript>Sorry, your browser does not support JavaScript!</noscript>
  <!--base标签放在head标签中表示整篇文档的网站中的所有链接都是在浏览器的新标签页中打开；
如果想单独在新的标签页中打开一个链接，可以将target=“_blank”写在a标签href链接的后面；-->
  <base target="" />
    


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
                  <!-- Table -->
            <h1><%=error %></h1>
          		<%if(error.equals("")){ %>
          	   <table id="managemmentTable">
              	 <tr>
        	      	<th>学号</th>
        	      	<th>分数</th>
        	      	<th>日期</th>
              	</tr>
        
        		<%
        			for(ManagementBean managementBean: list){	
        		 %>
        		 <tr>
        			 <td><%=managementBean.getSno()%></td>
        			 <td><%=managementBean.getNum()%></td>
        			 <td><%=managementBean.getDate()%></td>
        		 </tr>
        		 <%
        		 	}}
        		  %>
        		</table>
        	<!-- TableEnd -->
            </div>
        </div>
      </div>
      <div class="footer">
      </div>
    </div>
  </body>
</html>
