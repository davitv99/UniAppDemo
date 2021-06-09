/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aua.student.controller;

import aua.student.model.StdModel;
import aua.student.model.StdUFModel;
import aua.student.service.StdService;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/studentacc")
@Slf4j

public class StdCont {

    @Autowired
    private StdService stdservice;
    String fail = "You already have an account";
    String success = "Successfully created";
    @PostMapping(path = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @Transactional
    public Optional<StdModel> register(@RequestBody(required = true) StdUFModel newstd) {
        Optional<StdModel> regstd = stdservice.studentreg(newstd);
        if (regstd.isPresent()) {
            return regstd;
        }
        return null;
    }

    @GetMapping(path = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @Transactional
    public ResponseEntity<?> findAll() {
        List<StdModel> foundList = stdservice.findAll();

        if (!foundList.isEmpty()) {
            return ResponseEntity.ok().body(foundList);
        }

        return ResponseEntity.badRequest().body("There is no student in you database");
    }

    @DeleteMapping(path = "/deletestd", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @Transactional
    public ResponseEntity<?> deleteStd(@RequestBody(required = true) int bndgpa) {
        int n = stdservice.removestd(bndgpa);
        return ResponseEntity.ok().body("There are total " + n + " students that were eliminated due low gpa");
    }

    @DeleteMapping(path = "/deleteall", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @Transactional
    public ResponseEntity<?> removeall() {
        boolean a = stdservice.removeall();
        if (a == true) {
            return ResponseEntity.ok().body("Successfully deleted");
        }
        return ResponseEntity.badRequest().body("Error occured");
    }

}
