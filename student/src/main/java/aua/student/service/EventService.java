/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aua.student.service;

import aua.student.model.EventModel;
import aua.student.repository.EventRepo;
import java.time.LocalDate;

import java.time.LocalDateTime;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author davitv
 */
@Service
@Slf4j
public class EventService {

    @Autowired
    private EventRepo eventrepo;

    public void createEvent(String id, String email) {
        EventModel event = new EventModel();
        event.setDateOfReg(LocalDate.now());
        event.setMessage("Student created with id: " + id + " email: " + email);
        event.setId(id);
        event.setEmail(email);
        event.setType("STUDENT_CREATED");
        eventrepo.save(event);

    }

    public List<EventModel> findAll() {
        return eventrepo.findAll();
    }
}
