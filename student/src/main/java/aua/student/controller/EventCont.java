/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aua.student.controller;

import antlr.debug.Event;
import aua.student.model.EventModel;
import aua.student.service.EventService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author davitv
 */
@RestController
@RequestMapping("/api/v1/events")
@Slf4j
public class EventCont {
    @Autowired
    private EventService eventservice;
    
    @GetMapping(path = "/list",produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?>eventReport(){
    List<EventModel> events=eventservice.findAll();
        if(events.isEmpty()){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("The list is empty");
        }
        return ResponseEntity.status(HttpStatus.OK).body(events);
    
    }
    
    
    
    
}
