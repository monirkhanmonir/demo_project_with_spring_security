package com.excellenceict.eprescription.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.NaturalId;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Data
public class UserRole extends BaseModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Long id;
	@NaturalId
	private String roleName;
	@ManyToMany(mappedBy = "roles")
	@JsonIgnore
	private List<UserInfo> users= new ArrayList<UserInfo>();
	

}
