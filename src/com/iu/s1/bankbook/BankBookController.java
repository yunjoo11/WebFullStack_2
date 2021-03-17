package com.iu.s1.bankbook;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iu.s1.util.ActionForward;

/**
 * Servlet implementation class BankBookController
 */
@WebServlet("/BankBookController")
public class BankBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private BankBookService bankBookService;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BankBookController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		// controller 객체 생성 후 자동 호출 되는 초기화 메서드
		bankBookService = new BankBookService();
		BankBookDAO bankBookDAO = new BankBookDAO();
		bankBookService.setBankBookDAO(bankBookDAO);

	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// /WebFullStack_2/bankbook/bankbookList.do

		String uri = request.getRequestURI();
		int index= uri.lastIndexOf("/");
		uri = uri.substring(index+1); //bankbookList.do
		
		ActionForward actionForward = null;
		try {
			if(uri.equals("bankbookList.do")) {
				actionForward = bankBookService.getList(request);
			}else if(uri.equals("bankbookSelect.do")) {
				actionForward = bankBookService.getSelect(request);
			}
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("errorrrr");
		}
		
		//forward, redirect
		if(actionForward.ischeck()) {
			RequestDispatcher view = request.getRequestDispatcher(actionForward.getPath());
			view.forward(request, response);
		}else {
			response.sendRedirect(actionForward.getPath());
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
