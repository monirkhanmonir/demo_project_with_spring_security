package com.excellenceict.eprescription.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@MappedSuperclass
@Data
public abstract class BaseModel implements Serializable {
	private static final long serialVersionUID = 1L;

//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private long id;
	@Column(updatable = false)
	private String createdBy;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false)
	private Date createdAt;
	private String updatedBy;
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedAt;
	private Boolean isActive;
	
	@PrePersist
	public void setPreInsertData() {
		this.createdAt = new Date();
		this.isActive = true;
	}
	
	@PreUpdate
	public void setPreUpdateData() {
		this.createdAt = new Date();
	}
}
