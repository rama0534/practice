package com.rama.hellocontroller;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;


public class Student {


    @Pattern(regexp = "[^0-9]*")
    private String studentName;

    @Size(min=5,max=20)
    private String studentHobby;


    private Long studentMobile;

    @Past
    private Date studentDOB;

    private List<String> studentSkills;

    private Address studentAddress;

    public Address getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(Address studentAddress) {
        this.studentAddress = studentAddress;
    }
    //    private ArrayList<String> studentSkills;



    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentHobby() {
        return studentHobby;
    }

    public void setStudentHobby(String studentHobby) {
        this.studentHobby = studentHobby;
    }

    public Long getStudentMobile() {
        return studentMobile;
    }

    public void setStudentMobile(Long studentMobile) {
        this.studentMobile = studentMobile;
    }

    public Date getStudentDOB() {
        return studentDOB;
    }

    public void setStudentDOB(Date studentDOB) {
        this.studentDOB = studentDOB;
    }

    //    public List<String> getStudentSkills() {
    //        return studentSkills;
    //    }
    //
    //    public void setStudentSkills(ArrayList<String> studentSkills) {
    //        this.studentSkills = studentSkills;
    //    }


    public List<String> getStudentSkills() {
        return studentSkills;
    }

    public void setStudentSkills(List<String> studentSkills) {
        this.studentSkills = studentSkills;
    }
}
