package com.health.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Class_information {

    @Id
    @TableGenerator(name = "class_in",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE,generator = "class_in")
    private Integer id;

    @NotNull(message = "班号必传")
    private Integer class_id;

    @NotNull(message = "班名必传")
    private String class_name;

    @NotNull(message = "人数必传")
    private Integer class_num;

    @NotNull(message = "教师号必传")
    private Integer teacher_id;

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

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public Integer getClass_num() {
        return class_num;
    }

    public void setClass_num(Integer class_num) {
        this.class_num = class_num;
    }

    public Integer getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(Integer teacher_id) {
        this.teacher_id = teacher_id;
    }

    public Class_information(){

    }
}
