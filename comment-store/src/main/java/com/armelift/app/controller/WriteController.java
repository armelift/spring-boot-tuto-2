package com.armelift.app.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.armelift.app.model.CommentModel;
import com.armelift.app.service.CommentService;

@Controller
public class WriteController {

	@Autowired
	private CommentService service;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public @ResponseBody String create(
			@RequestParam("pageId") final String pageId,
			@RequestParam("userName") final String userName) throws IOException{

		CommentModel model = new CommentModel();
		model.setPageId(pageId);
		model.setUserName(userName);
		String id = service.put(model);

		return id;
	}
	
}
