/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aua.student.service;

import aua.student.model.StdModel;
import aua.student.repository.StdRepo;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StdService {

    @Autowired
    private StdRepo stdrepo;

    public Optional<StdModel> studentreg(StdModel newstudent) {
        Optional<StdModel> currentstd = stdrepo.findByEmail(newstudent.getEmail());
        if (!currentstd.isPresent()) {
            StdModel regstd = stdrepo.save(newstudent);
            log.info("Student successfully added");
            return Optional.ofNullable(regstd);
        }
        log.info("There is an account with this email, you can log in");
        return Optional.empty();
    }

    public List<StdModel> findAll() {
        return stdrepo.findAll();
    }

    public int removestd(Integer boundgpa) {
        int n = 0;
        List<StdModel> stdlist = findAll();
        for (StdModel stdmodel : stdlist) {
            if (stdmodel.getGpa() < boundgpa) {
                stdrepo.delete(stdmodel);
                n++;
            }
        }
        log.info(n + " number of students were eliminated due low GPA");
        return n;
    }
    public Boolean removeall() {
    stdrepo.deleteAll();
    if(stdrepo.count()==0){
    return true;
    }
    return false;
    }
    

}
