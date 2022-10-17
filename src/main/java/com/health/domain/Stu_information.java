package com.health.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Stu_information {

    @Id
    @TableGenerator(name = "stu_in",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE,generator = "stu_in")
    private Integer id;

    @NotNull(message = "学号必传")
    private Integer student_id;

    @NotNull(message = "卡号必传")
    private String student_card;

    @NotNull(message = "班号必传")
    private Integer class_id;

    @NotNull(message = "姓名必传")
    private String student_name;

    @NotNull(message = "性别必传")
    private String student_sex;

    @NotNull(message = "年龄必传")
    private Integer student_age;

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

    public String getStudent_card() {
        return student_card;
    }

    public void setStudent_card(String student_card) {
        this.student_card = student_card;
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

    public Integer getStudent_age() {
        return student_age;
    }

    public void setStudent_age(Integer student_age) {
        this.student_age = student_age;
    }

    public Stu_information(){}
}
