package com.excellenceict.eprescription.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.excellenceict.eprescription.anotation.ApiController;
import com.excellenceict.eprescription.dto.Response;
import com.excellenceict.eprescription.dto.TestModelDto;
import com.excellenceict.eprescription.model.TestModel;
import com.excellenceict.eprescription.service.TestServiceInterF;
import com.excellenceict.eprescription.util.ResponseBuilder;
import com.excellenceict.eprescription.util.UrlConstraint;

@ApiController
@RequestMapping("")
public class TextController {
	
	@Autowired
	private TestServiceInterF testservice; 
	
	@GetMapping("/home")
	public void getHome() {
		System.out.println("Accept controller");
	}

	@PostMapping("/save")
	public Response saveUser(@RequestBody TestModelDto userdto, BindingResult result) {
		if(result.hasErrors()) {
			return ResponseBuilder.getFailorResponse(result, "Bean binding error");
		}else {
			return testservice.saveUser(userdto);
		}
	}
	
	@PutMapping("/update/{id}")
	public Response updateUser(@PathVariable("id") Long id, @RequestBody TestModelDto userdto, BindingResult result) {
		if(result.hasErrors()) {
			return ResponseBuilder.getFailorResponse(result, "Bean binding error");
		}else {
			return testservice.updateUser(id, userdto);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public Response deleteUser(@PathVariable("id") Long id) {
			return testservice.deleteUser(id);
	}
	
	@GetMapping("/getone/{id}")
	public Response getUserById(@PathVariable("id") Long id) {
			return testservice.getUser(id);
	}
	
	@GetMapping("/getall")
	public Response getAll() {
			return testservice.getAllCourse();
	}
//	
//	@GetMapping("/getone/{id}")
//	public TestModel getUserById(@PathVariable("id") Long id) {
//		return testservice.getUser(id);
//	}
//	
//	@GetMapping("/delete/{id}")
//	public void deleteUserById(@PathVariable("id") Long id) {
//		 testservice.deleteUser(id);
//	}
//	
//	
//	@GetMapping("/courses")
//	public List<TestModel> getCourse() {
//		return this.testservice.getAllCourse();
//	}
	
	
}
