package com.iu.s1.bankbook;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.iu.s1.util.ActionForward;

public class BankBookService {

	private BankBookDAO bankBookDAO;
	
	public void setBankBookDAO(BankBookDAO bankBookDAO) {
		this.bankBookDAO = bankBookDAO;
	}




	public ActionForward getList(HttpServletRequest request) throws Exception{
		ActionForward actionForward = new ActionForward();
		List<BankBookDTO> ar = bankBookDAO.getList();
		
		request.setAttribute("list", ar);
		actionForward.setPath("../WEB-INF/bankBook/bankbookList.jsp");
		actionForward.setCheck(true);
		
		return actionForward;
	}
		
	
}
