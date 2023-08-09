package com.dungkun.controller.admin;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dungkun.constant.SystemConstant;
import com.dungkun.dao.INewDAO;
import com.dungkun.model.NewModel;
import com.dungkun.model.input.NewModelInput;

@WebServlet(urlPatterns = { "/admin-news" })
public class NewController extends HttpServlet {
	
	@Inject
	private INewDAO newDao;
	
	private static final long serialVersionUID = 1377134549611191015L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		NewModelInput newModelInput =  new NewModelInput();
		int currentPage = 0;
		List<NewModel> lists =  newDao.findAll(currentPage, 3);
		newModelInput.setList(lists);
		req.setAttribute(SystemConstant.MODEL, newModelInput);
		
		RequestDispatcher rd  = req.getRequestDispatcher("/views/admin/news/news-list.jsp");
		rd.forward(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}
}
