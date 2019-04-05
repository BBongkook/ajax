package service.Impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import dao.AddrDAO;
import dao.Impl.AddrDAOImpl;
import service.AddrService;
import utils.Command;

public class AddrServiceImpl implements AddrService {
	private AddrDAO adao = new AddrDAOImpl();
	private static final int PAGE_COUNT = 10;
	private static final int BLOCK_COUNT = 10;
	@Override
	public List<Map<String, String>> selectAddrList(HttpServletRequest request) {
		Map<String,String> paramMap = Command.getSingleMap(request);
		int page = 1;
		if(paramMap.get("page")!=null) {
			page = Integer.parseInt(paramMap.get("page"));
		}
		request.setAttribute("page", page);
		int lNum = page * PAGE_COUNT;
		int sNum = lNum -(PAGE_COUNT-1);
		paramMap.put("lNum", lNum+"");
		paramMap.put("sNum", sNum+"");
		List<Map<String,String>> addrList = adao.selectAddrList(paramMap);
		request.setAttribute("list", addrList);
		int totalCnt = adao.selectTotalAddrCount();
		request.setAttribute("totalCnt", totalCnt);
		int totalPageCnt = totalCnt/PAGE_COUNT;
		if(totalCnt%PAGE_COUNT>0) {
			totalPageCnt++;
		}
		int lBlock = ((page-1)/BLOCK_COUNT+1) * BLOCK_COUNT;
		int fBlock = lBlock-(BLOCK_COUNT-1);
		if(lBlock>totalPageCnt) {
			lBlock = totalPageCnt;
		}
		
		request.setAttribute("lBlock", lBlock);
		request.setAttribute("fBlock", fBlock);
		request.setAttribute("totalPageCnt", totalPageCnt);
		return addrList;
	}

	@Override
	public int selectTotalAddrCount() {
		return adao.selectTotalAddrCount();
	}

}
