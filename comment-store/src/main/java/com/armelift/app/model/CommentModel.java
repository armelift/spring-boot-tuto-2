package com.armelift.app.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

@Entity
@Table(name = "comments_model",
			indexes = {
					@Index(name = "idx_pageId", 
							columnList = "pageId"
						)
					}
		)
@TypeDefs({
	@TypeDef(name = "calendarUTC",
			typeClass = GregorianCalendar.class,
			defaultForType = Calendar.class)
})

public class CommentModel implements Serializable {

	private static final long serialVersionUID = 1L;

	
	@Id
	@Column(length = 36)
	private String id;
	
	@Version
	private Integer version;
	
	@Column(length = 32)
	private String pageId;
	
	@Temporal(TemporalType.TIMESTAMP) 
	@Type(type = "calendarUTC")
	private Calendar creationDate;
	
	@Temporal(TemporalType.TIMESTAMP) 
	@Type(type = "calendarUTC")
	private Calendar lastModificationDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getPageId() {
		return pageId;
	}

	public void setPageId(String pageId) {
		this.pageId = pageId;
	}

	public Calendar getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Calendar creationDate) {
		this.creationDate = creationDate;
	}

	public Calendar getLastModificationDate() {
		return lastModificationDate;
	}

	public void setLastModificationDate(Calendar lastModificationDate) {
		this.lastModificationDate = lastModificationDate;
	}
	
	
}
