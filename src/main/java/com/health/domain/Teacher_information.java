package com.health.domain;

import javax.persistence.*;

@Entity
public class Teacher_information {

    @Id
    @TableGenerator(name = "teacher",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE,generator = "teacher")
    private Integer id;

    private Integer teacher_id;

    private String teacher_name;

    private String teacher_sex;

    private Integer teacher_age;

    private String teacher_position;

    private Integer class_id;

    public Teacher_information(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(Integer teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public String getTeacher_sex() {
        return teacher_sex;
    }

    public void setTeacher_sex(String teacher_sex) {
        this.teacher_sex = teacher_sex;
    }

    public Integer getTeacher_age() {
        return teacher_age;
    }

    public void setTeacher_age(Integer teacher_age) {
        this.teacher_age = teacher_age;
    }

    public String getTeacher_position() {
        return teacher_position;
    }

    public void setTeacher_position(String teacher_position) {
        this.teacher_position = teacher_position;
    }

    public Integer getClass_id() {
        return class_id;
    }

    public void setClass_id(Integer class_id) {
        this.class_id = class_id;
    }


}
