/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aua.student.repository;

import aua.student.model.StdModel;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository

public interface StdRepo extends MongoRepository<StdModel, String> {
       Optional<StdModel> findByEmail(String email);
       Optional<StdModel> findByGpa(Integer gpa);  
}
