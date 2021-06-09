/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aua.student.courses.controller;

import aua.student.courses.model.CourseModel;
import aua.student.courses.model.CourseUFModel;
import aua.student.courses.service.CourseService;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author davitv
 */
@RestController
@RequestMapping("/api/v2/courses")
@Slf4j
public class CourseCont {
        @Autowired
    private CourseService cservice;
    @PostMapping(path = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @Transactional
    public ResponseEntity<?> register(@RequestBody(required = true) CourseUFModel newcourse) {
        Optional<CourseModel> regstd = cservice.studentreg(newcourse);
        if (regstd.isPresent()) {
            return ResponseEntity.ok().body("Course successfully created");
        }
        return ResponseEntity.badRequest().body("Course already exists");
    }

  @GetMapping(path = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @Transactional
    public ResponseEntity<?> findAll() {
        List<CourseModel> foundList = cservice.findAll();

        if (!foundList.isEmpty()) {
            return ResponseEntity.ok().body(foundList);
        }

        return ResponseEntity.badRequest().body("There is no course in you database");
    }
  
    
    
    
    
}
