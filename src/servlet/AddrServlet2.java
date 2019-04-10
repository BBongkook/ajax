package servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.AddrService;
import service.Impl.AddrServiceImpl;
import utils.Command;

public class AddrServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AddrService as = new AddrServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = Command.getCmd(request);
		if("list".equals(cmd)) {		
			as.selectAddrList(request);
			Map<String,Object> rMap = new HashMap<>();
			rMap.put("list", request.getAttribute("list"));
			rMap.put("page",request.getAttribute("page"));
			rMap.put("pageCount",request.getAttribute("pageCount"));
			rMap.put("blockCount",request.getAttribute("blockCount"));
			rMap.put("ad_dong",request.getParameter("ad_dong"));
			rMap.put("totalCnt",request.getAttribute("totalCnt"));
			rMap.put("fBlock", request.getAttribute("fBlock"));
			rMap.put("lBlock", request.getAttribute("lBlock"));
			Command.printJSON(response, rMap);
		} else if ("view".equals(cmd)) {
			as.selectAddr(request);
			Command.goPage(request, response, "/views/addr2/view");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = Command.getCmd(request);
		Map<String,String> param = Command.fromJSON(request);
		if("update".equals(cmd)) {
		int result = as.updateAddr(param);
		
		Map<String,String> rMap = new HashMap<>();
		rMap.put("adNum",param.get("adNum"));
		if(result==1) {
			rMap.put("msg", "수정 성공");
			rMap.put("update", "true");
			Command.printJSON(response, rMap);
		}else {
			rMap.put("msg", "수정 실패");
			rMap.put("update", "false");
			Command.printJSON(response, rMap);
		}
		}else if("delete".equals(cmd)) {
			Map<String,String> dMap = new HashMap<>();
			int result = as.deleteAddr(Integer.parseInt(param.get("adNum")));
			if(result==1) {
				dMap.put("msg", "삭제 성공");
				dMap.put("update", "true");
				Command.printJSON(response, dMap);
			}else {
				dMap.put("msg", "삭제 실패");
				dMap.put("update", "false");
				Command.printJSON(response, dMap);
			}
		}
	}
		

}
