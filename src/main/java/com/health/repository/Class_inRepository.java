package com.health.repository;

import com.health.domain.Class_information;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface Class_inRepository  extends JpaRepository<Class_information,Integer> {

    @Modifying
    @Transactional
    @Query("DELETE FROM Class_information where id = ?1")
    void deleteByClass_id(Integer id);

    //修改学生信息
    @Modifying
    @Transactional
    @Query("UPDATE Class_information n set n.class_id=?1 ,n.class_name=?2,n.class_num=?3,n.teacher_id=?4 where id =?5")
    void updateByStu_id(Integer class_id,String class_name,Integer class_num,Integer teacher_id,Integer id);

}
