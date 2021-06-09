/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aua.student.courses.repository;

import aua.student.courses.model.CourseModel;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author davitv
 */
public interface CourseRepo extends MongoRepository<CourseModel, String>{
    Optional<CourseModel> findByFaculty(String email);

    public Optional<CourseModel> findByName(String faculty);
}
