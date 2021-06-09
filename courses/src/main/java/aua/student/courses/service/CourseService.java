/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aua.student.courses.service;

import aua.student.courses.model.CourseModel;
import aua.student.courses.model.CourseUFModel;
import aua.student.courses.repository.CourseRepo;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author davitv
 */
@Service
@Slf4j

public class CourseService {
    @Autowired  
    private CourseRepo cRepo;
    public static CourseUFModel dtotoEntityConvert(CourseModel csmodel) {
        CourseUFModel csufmodel = new CourseUFModel();
        try {
            BeanUtils.copyProperties(csmodel, csufmodel);
        } catch (BeansException e) {
            throw new RuntimeException("Error while processing information", e);
        }
        return csufmodel;
    }

    public static CourseModel convertEntitytoDto(CourseUFModel csufmodel) {
        CourseModel csmodelfinal = new CourseModel();
        try {
            BeanUtils.copyProperties(csufmodel, csmodelfinal);

        } catch (BeansException e) {
            throw new RuntimeException("Error while processing information", e);
        }
        return csmodelfinal;
    }
    public Optional<CourseModel> studentreg(CourseUFModel newcourseUf) {
        CourseModel courseData = convertEntitytoDto(newcourseUf);
        Optional<CourseModel> currentcs = cRepo.findByName(courseData.getName());
        if (!currentcs.isPresent()) {
            final CourseModel regcs = cRepo.save(courseData);
            log.info("Course successfully added");
           
            return Optional.ofNullable(regcs);
        }
        log.info("There is such course check you input");
        return Optional.empty();
    }
     public List<CourseModel> findAll() {
        return cRepo.findAll();
    }

}
