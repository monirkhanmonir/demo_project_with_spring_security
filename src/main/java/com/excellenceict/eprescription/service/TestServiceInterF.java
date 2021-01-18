package com.excellenceict.eprescription.service;

import java.util.List;

import com.excellenceict.eprescription.dto.Response;
import com.excellenceict.eprescription.dto.TestModelDto;
import com.excellenceict.eprescription.model.TestModel;

public interface TestServiceInterF {
	
	public Response getAllCourse();
	public Response saveUser(TestModelDto user);
	public Response updateUser(long id, TestModelDto dto);
	public Response getUser(Long id);
	public Response deleteUser(long id);

}
