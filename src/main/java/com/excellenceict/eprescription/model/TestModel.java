package com.excellenceict.eprescription.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import lombok.Data;



@Entity
@Data
public class TestModel extends BaseModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String address;
	
	
	



	@Override
	public String toString() {
		return "TestModel [ name=" + name + ", address=" + address + "]";
	}
	
	
}
