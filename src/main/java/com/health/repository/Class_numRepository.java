package com.health.repository;

import com.health.domain.Abnormal;
import com.health.domain.Class_number;
import com.health.domain.Stu_information;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.NamedNativeQuery;
import java.awt.print.Pageable;
import java.lang.annotation.Native;
import java.util.List;

public interface Class_numRepository extends JpaRepository<Class_number,Integer> {

    //通过班级号查询
    @Query("select n  from Class_number n where n.class_id=?1")
    public List<Class_number> findByClassID(Integer class_id);

    //通过班级号和学号查询
    @Query("select n  from Class_number n where n.student_id=?1")
    public List<Class_number> findByOne(Integer student_id);

    //通过班级号查询
    @Query("select n  from Class_number n where n.student_sex=?1")
    public List<Class_number> findBySex(String sex);

    //通过班级号和学号查询
//    "select DISTINCT new Class_number(n.student_name,n.student_temp)  from Class_number n ORDER BY n.student_temp DESC "

    @Query("select DISTINCT new Class_number(n.student_name,n.student_temp)  from Class_number n ORDER BY n.student_temp DESC ")
    public List<Class_number> findByTemp(Pageable pageable);

    //通过班级号查询
    @Query("select DISTINCT new Class_number(n.student_name,n.student_temp)  from Class_number n where n.class_id=?1 ORDER BY n.student_temp DESC")
    public List<Class_number> findByClassIDF(Integer class_id,Pageable pageable);
}
