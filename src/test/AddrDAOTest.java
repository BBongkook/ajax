package test;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import dao.AddrDAO;
import dao.Impl.AddrDAOImpl;

public class AddrDAOTest {
	AddrDAO adao = new AddrDAOImpl();
	
	@Test
	public void test() {
		List<Map<String,String>> addrList = adao.selectAddrList(null);
		assertEquals(358425, addrList.size());
	}

}
