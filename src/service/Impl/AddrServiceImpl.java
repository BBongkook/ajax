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
	
	@Override
	public List<Map<String, String>> selectAddrList(HttpServletRequest request) {
		Map<String,String> paramMap = Command.getSingleMap(request);
		int page = 1;
		int pageCount = 10;
		int blockCount = 10;
		//String ad_dong = null;
		if(paramMap.get("page")!=null && !"".equals(paramMap.get("page"))) {
			page = Integer.parseInt(paramMap.get("page"));
		}
		if(paramMap.get("pageCount")!=null && !"".equals(paramMap.get("pageCount"))) {
			pageCount = Integer.parseInt(paramMap.get("pageCount"));
		}
		if(paramMap.get("blockCount")!=null) {
			blockCount = Integer.parseInt(paramMap.get("blockCount"));
		}
		/*
		 * if(paramMap.get("ad_dong")!=null && !"".equals(paramMap.get("ad_dong"))) {
		 * ad_dong = paramMap.get("ad_dong"); } else { paramMap.put("ad_dong", ad_dong);
		 * }
		 */
		String ad_sido = paramMap.get("ad_sido");
		String ad_gugun = paramMap.get("ad_gugun");
		String ad_dong = paramMap.get("ad_dong");
		request.setAttribute("ad_sido", ad_sido);
		request.setAttribute("ad_dong", ad_dong);
		request.setAttribute("ad_gugun", ad_gugun);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("blockCount", blockCount);
		request.setAttribute("page", page);
		int lNum = page * pageCount;
		int sNum = lNum -(pageCount-1);
		paramMap.put("lNum", lNum+"");
		paramMap.put("sNum", sNum+"");
		List<Map<String,String>> addrList = adao.selectAddrList(paramMap);
		request.setAttribute("list", addrList);
		int totalCnt = adao.selectTotalAddrCount(paramMap);
		request.setAttribute("totalCnt", totalCnt);
		int totalPageCnt = totalCnt/pageCount;
		if(totalCnt%pageCount>0) {
			totalPageCnt++;
		}
		int lBlock = ((page-1)/blockCount+1) * blockCount;
		int fBlock = lBlock-(blockCount-1);
		if(lBlock>totalPageCnt) {
			lBlock = totalPageCnt;
		}
		
		request.setAttribute("lBlock", lBlock);
		request.setAttribute("fBlock", fBlock);
		request.setAttribute("totalPageCnt", totalPageCnt);
		List<String> asList = adao.selectAdsido();
		request.setAttribute("asList", asList);
		List<String> aggList = selectAdGugunList(ad_sido);
		request.setAttribute("agList", aggList);
		return addrList;
	}

	@Override
	public int selectTotalAddrCount() {
		//return adao.selectTotalAddrCount();
		return 0;
	}

	@Override
	public void selectAddr(HttpServletRequest request) {
		Map<String,String> paramMap = Command.getSingleMap(request);
		int page = 1;
		int pageCount = 10;
		if(paramMap.get("page")!=null) {
			page = Integer.parseInt(paramMap.get("page"));
		}
		if(paramMap.get("pageCount")!=null) {
			pageCount = Integer.parseInt(paramMap.get("pageCount"));
		}
		request.setAttribute("page", page);
		request.setAttribute("pageCount", pageCount);
		Map<String,String> addrMap = adao.selectAddr(paramMap);
		request.setAttribute("addr", addrMap);
		
	}

	@Override
	public int updateAddr(Map<String, String> uMap) {
		// TODO Auto-generated method stub
		return adao.updateAddr(uMap);
	}

	@Override
	public int deleteAddr(int adNum) {
		// TODO Auto-generated method stub
		return adao.deleteAddr(adNum);
	}

	@Override
	public List<String> selectAdsido() {
		// TODO Auto-generated method stub
		return adao.selectAdsido();
	}

	@Override
	public List<String> selectAdGugunList(String adSido) {
		// TODO Auto-generated method stub
		return adao.selectAdGugunList(adSido);
	}

}
