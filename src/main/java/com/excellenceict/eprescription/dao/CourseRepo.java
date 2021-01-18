package com.excellenceict.eprescription.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.excellenceict.eprescription.model.Course;
import com.excellenceict.eprescription.model.TestModel;

@Repository
public interface CourseRepo extends JpaRepository<Course, Long>{

}
