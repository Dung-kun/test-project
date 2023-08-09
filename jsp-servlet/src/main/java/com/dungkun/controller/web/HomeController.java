package com.dungkun.controller.web;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dungkun.model.CategoryModel;
import com.dungkun.service.ICategoryService;

@WebServlet(urlPatterns = { "/home" })
public class HomeController extends HttpServlet {
	
	private static final long serialVersionUID = 713134855993621166L;

	@Inject
	private ICategoryService categoryService;
	
//	@Inject
//	private INewService newService;

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setAttribute("newsbycategoryid", this.newService.findByCategoryId(1L));
		List<CategoryModel> lists = categoryService.findAll();
		req.setAttribute("categories", lists);
		RequestDispatcher rd = req.getRequestDispatcher("/views/web/home.jsp");
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}
