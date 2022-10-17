package com.health.repository;

import com.health.domain.Abnormal;
import com.health.domain.Class_leaver;
import com.health.domain.Class_register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Class_reRepository extends JpaRepository<Class_register,Integer> {

    //通过班级号查询
    @Query("select n  from Class_register n where n.class_id=?1")
    public List<Class_register> findByClassID(Integer class_id);

}
