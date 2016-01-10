package com.dbdao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import com.db.DbConnection;
import com.model.ManagementBean;

public class InsertManagementDBO {
	public String insert(ManagementBean managementBean) {
		ResultSet rs = null;
		Statement stmt = null;
		Connection connection = new DbConnection().getConnect();
		String sql = "SELECT COUNT(*) FROM 学生 WHERE 学号=" + "'"
				+ managementBean.getSno() + "'";
		// 检查数据库中是否以存在元组
		try {
			stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				int i = rs.getInt(1);
				if (i == 0) {
					stmt.close();
					connection.close();
					// 无此学生
					return "-1";
				}
			}
			// 在管理表中插入数据
			sql = "Insert INTO 管理(学号,扣分,日期) values('" + managementBean.getSno()
					+ "'," + managementBean.getNum() + ",'"
					+ managementBean.getDate() + "')";
			stmt.executeUpdate(sql);
			stmt.close();
			connection.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "1";
	}
}
