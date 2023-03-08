package com.iei.cal.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.iei.cal.model.vo.Cal;
import com.iei.cal.model.vo.CalCheck;

import common.JDBCTemplate;

public class CalDao {

	public ArrayList<CalCheck> selectAllCalCheck(Connection conn, int userNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<CalCheck> list = new ArrayList<CalCheck>();
		String query = "select '출석체크' title,to_char(check_day,'YYYY-MM-DD') as start_date from cal_check where user_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, userNo);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				CalCheck cc = new CalCheck();
				cc.setStart(rset.getString("start_date"));
				cc.setTitle(rset.getString("title"));
				list.add(cc);
;			}
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
