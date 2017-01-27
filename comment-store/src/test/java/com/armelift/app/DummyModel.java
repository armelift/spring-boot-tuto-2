package com.armelift.app;

import java.util.UUID;

import com.armelift.app.model.CommentModel;

public class DummyModel {

	public static CommentModel get(){
		CommentModel model = new CommentModel();
		
		model.setId(UUID.randomUUID().toString());
		model.setPageId("dslkfsdlkf");
		model.setUserName("patrice");
		return model;
	}
}
