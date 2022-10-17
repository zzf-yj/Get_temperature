package com.health.repository;


import com.health.domain.Class_leaver;
import com.health.domain.Stu_information;
import com.health.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,String> {

    //查询登录账号
    @Query("select n FROM User n where n.account=?1 AND n.password=?2 AND n.identity=?3")
    public List<User> findByUser(String account,String password,String identity);


}
