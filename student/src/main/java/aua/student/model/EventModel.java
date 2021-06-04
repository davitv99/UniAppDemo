/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aua.student.model;

import java.io.Serializable;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author davitv
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "events")
public class EventModel implements Serializable {

    @Id
    private String id;
    private LocalDate dateOfReg;
    private String email;
    private String message;
    private String type;

//    public void setEventDateOfReg(LocalDateTime now) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}
