package com.excellenceict.eprescription.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.excellenceict.eprescription.dao.TestDao;
import com.excellenceict.eprescription.dto.Response;
import com.excellenceict.eprescription.dto.TestModelDto;
import com.excellenceict.eprescription.model.Course;
import com.excellenceict.eprescription.model.TestModel;
import com.excellenceict.eprescription.util.ResponseBuilder;

@Service
public class TestService implements TestServiceInterF {

	@Autowired
	TestDao dao;

	@Autowired
	ModelMapper mapper;
	private final String root = "TestModel ";

	public TestService() {

//		list = new ArrayList<TestModel>();
//		list.add(new TestModel(1, "Monir","has"));
//		list.add(new TestModel(1, "Mojnu",new Address(1, "Bangladesh", "Dhaka","2/3")));
//		list.add(new TestModel(1, "Habib",new Address(1, "Bangladesh", "Dhaka","2/3")));

	}

	@Override
	public Response getAllCourse() {
		List<TestModel> modelList = dao.findAll();
		if (modelList != null) {
			List<TestModelDto> dtoList =  this.getAllUser(modelList);
			if (dtoList != null) {
				return ResponseBuilder.getSuccessResponse(HttpStatus.OK, root + "Get success", dtoList);
			} else {
				return ResponseBuilder.getFailorResponse(HttpStatus.INTERNAL_SERVER_ERROR, root+ " Internal server error");
			}

		} else {
			return ResponseBuilder.getFailorResponse(HttpStatus.NOT_FOUND, root + " Not found");
		}
	
	}

	@Override
	public Response saveUser(TestModelDto userdto) {
		TestModel model = mapper.map(userdto, TestModel.class);
		model = dao.save(model);
		if (model != null) {
			return ResponseBuilder.getSuccessResponse(HttpStatus.CREATED, root + "created success", model);
		} else {
			return ResponseBuilder.getFailorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server errot");
		}
	}

	@Override
	public Response updateUser(long id, TestModelDto dto) {
		System.out.println("User id: +++++++++" + id);

		TestModel model = dao.getOne(id);
		if (model == null) {
//			mapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
			return ResponseBuilder.getFailorResponse(HttpStatus.NOT_FOUND, root + " Not found");
		} else {
			mapper.map(dto, model);
//			 mapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
			model = dao.save(model);

			if (model != null) {
				return ResponseBuilder.getSuccessResponse(HttpStatus.OK, root + "Update success", null);
			} else {
				return ResponseBuilder.getFailorResponse(HttpStatus.INTERNAL_SERVER_ERROR,
						root + " Internal server error");
			}

		}
	}

	@Override
	public Response getUser(Long id){
		TestModel model = dao.getOne(id);
		if (model != null) {
			System.out.println("data"+model.toString());
			mapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
			TestModelDto dto = mapper.map(model, TestModelDto.class);
			if (model != null) {
				return ResponseBuilder.getSuccessResponse(HttpStatus.OK, root + "Update success", dto);
			} else {
				return ResponseBuilder.getFailorResponse(HttpStatus.INTERNAL_SERVER_ERROR,
						root+ " Internal server error");
			}

		} else {
			System.out.println("Not found"+model.toString());
			return ResponseBuilder.getFailorResponse(HttpStatus.NOT_FOUND, root + " Not found");
		}
	}

	@Override
	public Response deleteUser(long id) {
		TestModel model = dao.getOne(id);
		if (model == null) {

			return ResponseBuilder.getFailorResponse(HttpStatus.NOT_FOUND, root + " Not found");
		} else {
			model.setIsActive(false);
			model = dao.save(model);
			if (model != null) {
				return ResponseBuilder.getSuccessResponse(HttpStatus.OK, root + " Delete success", null);
			} else {
				return ResponseBuilder.getFailorResponse(HttpStatus.INTERNAL_SERVER_ERROR,
						root + " Internal server error");
			}

		}
	}
	
	private List<TestModelDto> getAllUser(List<TestModel> models){
			List<TestModelDto> dtoList = new ArrayList<TestModelDto>();
			
			models.forEach(model->{
				mapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
				TestModelDto dto = mapper.map(model, TestModelDto.class);
				dtoList.add(dto);
			});
		
		return dtoList;
	}

}
