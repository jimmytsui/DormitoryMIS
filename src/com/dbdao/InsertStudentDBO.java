package com.dbdao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.db.DbConnection;
import com.model.StudentBean;

public class InsertStudentDBO {
	public String setinfo(StudentBean studentBean) {
		ResultSet rs = null;
		Statement stmt = null;
		Connection connection = new DbConnection().getConnect();
		String sql = "SELECT COUNT(*) FROM 学生 WHERE 学号=" + "'"
				+ studentBean.getSno() + "'";
		// 检查数据库中是否以存在元组
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				int i = rs.getInt(1);
				if (i > 0) {
					stmt.close();
					connection.close();
					// 以存在此学生
					return "-1";
				}
			}
			sql = "Insert INTO 学生 values(" + "'" + studentBean.getSno() + "','"
					+ studentBean.getName() + "','" + studentBean.getClasses()
					+ "')";
			stmt.executeUpdate(sql);
			stmt.close();
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return "1";
	}
}
