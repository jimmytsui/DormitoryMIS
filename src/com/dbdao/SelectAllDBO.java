package com.dbdao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.db.DbConnection;
import com.model.StudentBean;

public class SelectAllDBO {
	public List<StudentBean> getinfo(){
		ResultSet rs = null;
		Connection connection = new DbConnection().getConnect();
		String sql = "SELECT 学生.*,宿舍.*,入住.床位号 from 学生,宿舍,入住 where 学生.学号="
				+ "入住.学号 and 入住.寝室号=宿舍.寝室号 ";
		List<StudentBean> list = new ArrayList<>();
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			// 获取数据库信息
			while (rs.next()) {
				StudentBean studentBean = new StudentBean();
				studentBean.setSno(rs.getString("学号"));
				studentBean.setName(rs.getString("姓名"));
				studentBean.setClasses(rs.getString("所在班级"));
				studentBean.setDno(rs.getString("寝室号"));
				studentBean.setBno(rs.getInt("床位号"));
				list.add(studentBean);
			}
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}
}
