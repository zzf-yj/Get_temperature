package com.health.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Abnormal {

    @Id
    @TableGenerator(name = "Abnormal",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE,generator = "Abnormal")
    private Integer id;

    @NotNull(message = "学号必传")
    private Integer student_id;

    @NotNull(message = "班号必传")
    private Integer class_id;

    @NotNull(message = "姓名必传")
    private String student_name;

    @NotNull(message = "性别必传")
    private String student_sex;

    @NotNull(message = "体温必传")
    private String student_temp;

    @NotNull(message = "时间必传")
    private Date date;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Abnormal(){}
}
