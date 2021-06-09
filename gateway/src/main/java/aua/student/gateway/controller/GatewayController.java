/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aua.student.gateway.controller;

import java.lang.String;
import aua.student.gateway.model.StdModel;
import static java.lang.Math.log;
import java.net.URI;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author davitv
 */
@RestController
@RequestMapping("/api/v2/gateway")
public class GatewayController {

    private RestTemplate restTemplate = new RestTemplate();
    public String uri = "http://student:9095/api/v2/studentacc/register";

    @PostMapping(path = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addStudent(@RequestBody(required = true) StdModel newstd) {
        String result = restTemplate.postForObject(uri, newstd, String.class);
        if(result!=null){
        return ResponseEntity.ok().body("Success");
        }
        return ResponseEntity.badRequest().body("Fail");
    }
}
