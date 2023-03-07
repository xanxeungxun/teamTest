package com.iei.cal.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.iei.cal.model.vo.Cal;

import common.JDBCTemplate;

public class CalDao {

	public ArrayList<Cal> selectAllCalCheck(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Cal> list = new ArrayList<Cal>();
		String query = "select * from cal_check";
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Cal c = new Cal();
				c.setCheckNo(rset.getInt("check_no"));
				c.setCheckDay(rset.getString("check_day"));
				c.setUserNo(rset.getInt("user_no"));
				list.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return list;
	}

}
