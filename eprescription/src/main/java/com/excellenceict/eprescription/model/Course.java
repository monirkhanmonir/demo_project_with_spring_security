package com.excellenceict.eprescription.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity

public class Course extends BaseModel{

	@Id
	private int id;
	private int code;
	private String subject;
	
}
