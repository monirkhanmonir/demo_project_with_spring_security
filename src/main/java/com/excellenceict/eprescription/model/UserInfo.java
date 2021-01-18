package com.excellenceict.eprescription.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.NaturalId;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
public class UserInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String email;
	@NaturalId
	private String username;
	private String passsword;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="role", joinColumns = @JoinColumn(name="user_id"), inverseJoinColumns = @JoinColumn(name="role_id"))
	@ToString.Exclude
	private List<UserRole> roles;
	
}
