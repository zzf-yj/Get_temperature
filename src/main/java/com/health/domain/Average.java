package com.health.domain;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Average {

    @Id
    @TableGenerator(name = "Average",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE,generator = "Average")
    private Integer id;

    private String average_temp;

    private Integer student_num;

    public Average(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAverage_temp() {
        return average_temp;
    }

    public void setAverage_temp(String average_temp) {
        this.average_temp = average_temp;
    }

    public Integer getStudent_num() {
        return student_num;
    }

    public void setStudent_num(Integer student_num) {
        this.student_num = student_num;
    }


}
