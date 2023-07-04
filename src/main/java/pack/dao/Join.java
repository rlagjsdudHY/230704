package pack.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pack.dao.DBConnectionMgr;

public class Join {

	Connection conn = null;
	PreparedStatement pStmt = null;
	ResultSet rS = null;
	DBConnectionMgr pool = null;

	public Join() {
		pool = DBConnectionMgr.getInstance();
	}

	public int chkUserId(String userId) {

		int rtnCnt = 0;

		try {
			conn = pool.getConnection();
			String sql = "select count(*) from member where userId = ?";
			pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, userId);
			rS = pStmt.executeQuery();

			if (rS.next()) {
				rtnCnt = rS.getInt(1);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			
			if (rS != null) { try { rS.close(); } catch (SQLException e) { e.getMessage(); }  }
			if (pStmt != null) { try { pStmt.close(); } catch (SQLException e) {  e.getMessage(); } }
			if (conn != null) { try { conn.close(); } catch (SQLException e) { e.getMessage(); }  }
			
		}

		return rtnCnt;
	}

}