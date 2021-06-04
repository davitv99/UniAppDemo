/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aua.student.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="students")
public class StdModel implements Serializable {
    @Id
    @ApiModelProperty(hidden = true) 
    private String id;
    private String name;
    private String surename;
    private LocalDate birthday;
    private LocalDate dateOfReg = LocalDate.now();
    private String email;
    private Integer gpa;
}