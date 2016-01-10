package com.dbdao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.db.DbConnection;
import com.model.CheckinBean;

public class CheckinDBO {
	public String checkin(CheckinBean checkinBean) {
		ResultSet rs = null;
		Statement stmt = null;
		String sql = null;
		int peo = 0;
		Connection connection = new DbConnection().getConnect();
		try {
			stmt = connection.createStatement();
			sql = "SELECT checkin("+ "'"+checkinBean.getSno() + "','"
										+checkinBean.getDno() + "',"
										+ checkinBean.getBno() +")";
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				int i = rs.getInt(1);
					stmt.close();
					connection.close();
					return Integer.toString(i);
				}
			}
			
		 catch (Exception e) {
			// TODO: handle exception
		}
		return "1";

	}
}
