package dao.Impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.AddrDAO;
import db.DBCon;

public class AddrDAOImpl implements AddrDAO {
	private static String selectAddrListSql = "select * from \r\n" + 
			"(select rownum as rown, addr.* FROM \r\n" + 
			"(select * from address order by ad_num desc ) addr \r\n" + 
			"where rownum <= ?) \r\n" + 
			"where rown >=?";
	private static String selectAddrCount = "select count(1) from address";
	@Override
	public List<Map<String, String>> selectAddrList(Map<String, String> addr) {
		try {
			PreparedStatement ps = DBCon.open().prepareStatement(selectAddrListSql);
			ps.setString(1, addr.get("lNum"));
			ps.setString(2, addr.get("sNum"));
			ResultSet rs = ps.executeQuery();
			List<Map<String,String>> addrList = new ArrayList<>();
			while(rs.next()) {
				Map<String,String> address = new HashMap<>();
				address.put("ad_num", rs.getString("ad_num"));
				address.put("ad_sido", rs.getString("ad_sido"));
				address.put("ad_gugun", rs.getString("ad_gugun"));
				addrList.add(address);
			}
			return addrList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBCon.close();
		}
		
		return null;
	}
	@Override
	public int selectTotalAddrCount() {
		try {
			PreparedStatement ps = DBCon.open().prepareStatement(selectAddrCount);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBCon.close();
		}
		return 0;
	}
	
	
}
