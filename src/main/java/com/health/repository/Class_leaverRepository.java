package com.health.repository;

import com.health.domain.Class_leaver;
import com.health.domain.Class_number;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Class_leaverRepository extends JpaRepository<Class_leaver,Integer> {

    //通过班级号查询
    @Query("select n  from Class_leaver n where n.class_id=?1")
    public List<Class_leaver> findByClassID(Integer class_id);

    //通过学号查询
    @Query("select n  from Class_leaver n where n.student_id=?1")
    public List<Class_leaver> findByStuID(Integer student_id);

    //通过班级号和学号查询
    @Query("select n  from Class_leaver n where n.student_id=?1")
    public List<Class_leaver> findByOne(Integer student_id);
}
