package com.armelift.app.service;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.armelift.app.model.CommentModel;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class CommentServiceImplTest{

	@Autowired
	CommentModelRepository repository;
	
	CommentModel model;
	
	CommentServiceImpl systemUnderTest;
	
	@Before
	public void setup(){
		systemUnderTest = new CommentServiceImpl(repository);
		model = new CommentModel();
		
		model.setId(UUID.randomUUID().toString());
		model.setPageId("dslkfsdlkf");
		
		repository.deleteAll();
	}
	
	@Test
	public void testListNotFound() throws IOException{
		systemUnderTest.put(model);
		List<CommentModel> r = systemUnderTest.list(model.getPageId());
		
		assertTrue(!r.isEmpty());
		
	}
}
