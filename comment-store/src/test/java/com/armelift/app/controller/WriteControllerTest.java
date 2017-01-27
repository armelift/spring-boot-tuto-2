package com.armelift.app.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.armelift.app.DummyModel;
import com.armelift.app.model.CommentModel;
import com.armelift.app.service.CommentService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class WriteControllerTest {

	@Autowired
	private WebApplicationContext context;
	
	@Autowired
	private CommentService service;
	
	private MockMvc mvc;
	
	@Before
	public void setUp(){
		this.mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}
	
	public void testPost() throws Exception{
		
		CommentModel model = DummyModel.get();
		
		MvcResult result = this.mvc.perform(MockMvcRequestBuilders.post("/create")
					.param("pageId", model.getPageId())
					.param("userName", model.getUserName())
					)
					.andExpect(status().is(200))
					.andReturn();
		
		String id = result.getResponse().getContentAsString();
		
		CommentModel dbModel = service.get(id);
		assertNotNull(dbModel);
		
		
	}
}
