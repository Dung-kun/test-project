package com.dungkun.api;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dungkun.model.NewModel;
import com.dungkun.service.INewService;
import com.dungkun.utils.HttpUtil;
import com.dungkun.utils.JsonUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet(urlPatterns = { "/api-admin-new" })
public class NewAPI extends HttpServlet {

	@Inject
	private INewService newService;
		
	private static final long serialVersionUID = 7726981691113850265L;

	protected void doPost(HttpServletRequest req, HttpServletResponse rep) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		rep.setContentType("application/json");

		NewModel news = HttpUtil.of(req.getReader()).toModel(NewModel.class);
		news = newService.save(news);
		mapper.writeValue(rep.getOutputStream(), news);
	}

	protected void doPut(HttpServletRequest req, HttpServletResponse rep) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		rep.setContentType("application/json");

		NewModel news = HttpUtil.of(req.getReader()).toModel(NewModel.class);
		news = newService.update(news);
		mapper.writeValue(rep.getOutputStream(), news);
	}

	protected void doDelete(HttpServletRequest req, HttpServletResponse rep) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		rep.setContentType("application/json");
		String dataString = HttpUtil.of(req.getReader()).getValue();
		JsonNode jsonNode = mapper.readTree(dataString);
		List<Long> ids = JsonUtil.instance().getIdsListFromJsonNode(jsonNode);
		
		newService.delete(ids);
		mapper.writeValue(rep.getOutputStream(), ids);
	}

}
