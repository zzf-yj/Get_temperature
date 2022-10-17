package com.health.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Class_number {

    @Id
    @TableGenerator(name = "class_n",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE,generator = "class_n")
    private Integer id;

    private Integer class_id;

    private Integer student_id;

    private String student_name;

    private String student_sex;

    private String student_temp;

    private Date student_data;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClass_id() {
        return class_id;
    }

    public void setClass_id(Integer class_id) {
        this.class_id = class_id;
    }

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
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

    public Date getStudent_data() {
        return student_data;
    }

    public void setStudent_data(Date student_data) {
        this.student_data = student_data;
    }

    public Class_number(String student_name,String student_temp){
        this.student_name = student_name;
        this.student_temp = student_temp;
    }
    public Class_number(){}
}
