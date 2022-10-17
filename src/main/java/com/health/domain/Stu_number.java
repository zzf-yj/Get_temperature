package com.health.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Stu_number {

    @Id
    @TableGenerator(name = "stu_n",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE,generator = "stu_n")
    private Integer id;

    @NotNull(message = "体温必传")
    private String temp;

    private Date date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Stu_number(){}
}
