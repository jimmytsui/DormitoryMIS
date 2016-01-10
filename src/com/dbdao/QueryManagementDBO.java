package com.dbdao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.db.DbConnection;
import com.model.ManagementBean;

public class QueryManagementDBO {
	public List<ManagementBean> query(String sno) {
		ResultSet rs = null;
		Connection connection = new DbConnection().getConnect();
		List<ManagementBean> list = new ArrayList<>();

		// 查询
		String sql = "SELECT * from 管理 where 学号='" + sno + "'";
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			// 获取数据库信息
			while (rs.next()) {
				ManagementBean managementBean = new ManagementBean();
				managementBean.setSno(sno);
				managementBean.setNum(rs.getString("扣分"));
				managementBean.setDate(rs.getString("日期"));
				list.add(managementBean);
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
