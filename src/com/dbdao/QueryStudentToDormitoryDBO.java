package com.dbdao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.db.DbConnection;
import com.model.Dormitory;

//通过学生查询寝室信息
public class QueryStudentToDormitoryDBO {

	public QueryStudentToDormitoryDBO() {
		// TODO Auto-generated constructor stub

	}

	public java.util.List<Dormitory> getInfo(int mode, String sno) {
		ResultSet rs = null;
		Connection connection = new DbConnection().getConnect();
		String sql = "SELECT 宿舍.*,入住.床位号,学生.姓名 from 学生,宿舍,入住 where 学生.学号="
				+ "入住.学号 and 入住.寝室号=宿舍.寝室号 and 学生.学号=" + "'" + sno + "'";
		List<Dormitory> list = new ArrayList<>();
		try {
			Statement stmt = connection.createStatement();
			rs = stmt.executeQuery(sql);
			// 获取数据库信息
			while (rs.next()) {
				Dormitory dormitory = new Dormitory();
				dormitory.setName(rs.getString("姓名"));
				dormitory.setCno(rs.getString("寝室号"));
				dormitory.setMaxpeo(rs.getInt("应住人数"));
				dormitory.setPeo(rs.getInt("实住人数"));
				dormitory.setBno(rs.getInt("床位号"));
				list.add(dormitory);
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
