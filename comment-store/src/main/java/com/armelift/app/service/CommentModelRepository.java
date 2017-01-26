package com.armelift.app.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.armelift.app.model.CommentModel;

public interface CommentModelRepository extends CrudRepository<CommentModel, String>{

	@Query("select a from CommentModel a where a.pageId = ?1")
	List<CommentModel> findByPageId(String pageId);
}
