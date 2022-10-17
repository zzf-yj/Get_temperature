package com.health.domain;



import javax.persistence.*;

@Table(name = "user", uniqueConstraints = {@UniqueConstraint(columnNames="account")})
@Entity
public class User {

    @Id
    @TableGenerator(name = "Idup",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.TABLE,generator = "Idup")
    private Integer id;

    @Column(name = "account")
    private String account;

    private String password;

    private String identity;

    private Integer student_id;

    private Integer class_id;

    public User(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
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
}
