package com.health.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Class_leaver {

    @Id
    @TableGenerator(name = "class_l",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE,generator = "class_l")
    private Integer id;

    @NotNull(message = "学号必传")
    private Integer student_id;

    private Integer class_id;

    private String student_name;

    private String student_sex;

    private String student_temp;

    private String reason;

    private Date date;

    private String authorize;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public Integer getClass_id() {
        return class_id;
    }

    public void setClass_id(Integer class_id) {
        this.class_id = class_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_sex() {
        return student_sex;
    }

    public void setStudent_sex(String student_sex) {
        this.student_sex = student_sex;
    }

    public String getStudent_temp() {
        return student_temp;
    }

    public void setStudent_temp(String student_temp) {
        this.student_temp = student_temp;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getAuthorize() {
        return authorize;
    }

    public void setAuthorize(String authorize) {
        this.authorize = authorize;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Class_leaver(){}
}

