package com.excellenceict.eprescription.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.excellenceict.eprescription.model.TestModel;


public interface TestDao extends JpaRepository<TestModel, Long> {
//	TestModel findByIdAndIsActivateTrue(Long id);

}
