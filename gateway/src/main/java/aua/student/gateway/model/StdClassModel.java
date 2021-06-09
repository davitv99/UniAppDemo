/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aua.student.gateway.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author davitv
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StdClassModel {
    String email;
    List<CourseModel> courses;
    String name;
    String surename;
    Integer cquantity;
}
