package dao.Impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import dao.AddrDAO;
import db.DBCon;

public class AddrDAOImpl implements AddrDAO {
	private static String selectAddrListSql = "select * from \r\n" + 
			"(select rownum as rown, addr.* FROM \r\n" + 
			"(select * from address order by ad_num desc ) addr \r\n" + 
			"where rownum <= 20) \r\n" + 
			"where rown >=11";
	private static String selectAddrCount = "select count(1) from address";
	@Override
	public List<Map<String, String>> selectAddrList(Map<String, String> addr) {
		try {
			PreparedStatement ps = DBCon.getCon().prepareStatement(selectAddrListSql);
			ps.setString(1, addr.get("lNum"));
			ps.setString(2, addr.get("sNum"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	
}
