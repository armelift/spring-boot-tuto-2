package com.armelift.app.service;

import java.io.IOException;
import java.util.List;

import com.armelift.app.model.CommentModel;

public interface CommentService {

	String put(CommentModel model) throws IOException;
	
	List<CommentModel> list(String pageId) throws IOException;
	
	CommentModel get(String id);
	
	void delete(String id);
}
