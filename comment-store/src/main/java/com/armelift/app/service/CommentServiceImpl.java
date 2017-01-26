package com.armelift.app.service;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.armelift.app.model.CommentModel;

public class CommentServiceImpl implements CommentService {

	@Autowired
	CommentModelRepository repository;
	
	public CommentServiceImpl(){}
	
	//for unit test
	CommentServiceImpl(CommentModelRepository repository){
		this.repository = repository;
	}
	@Override
	@Transactional
	public String put(CommentModel model) throws IOException {
		if(StringUtils.isEmpty(model.getId())){
			model.setId(UUID.randomUUID().toString());
		}
		
		CommentModel dbModel = get(model.getId());
		
		if(dbModel != null){
			dbModel.setPageId(model.getPageId());
			dbModel.setLastModificationDate(Calendar.getInstance(TimeZone.getTimeZone("UTC")));
			repository.save(dbModel);

		}
		else{
			model.setCreationDate(Calendar.getInstance(TimeZone.getTimeZone("UTC")));
			model.setLastModificationDate(Calendar.getInstance(TimeZone.getTimeZone("UTC")));
			repository.save(model);
		}
		return model.getId();
	}

	@Override
	public List<CommentModel> list(String pageId) throws IOException {
		return repository.findByPageId(pageId);
	}

	@Override
	public CommentModel get(String id) {
		return repository.findOne(id);
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub

	}

}
