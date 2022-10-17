package com.health.repository;

import com.health.domain.Teacher_information;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


public interface TeacherRepository extends JpaRepository<Teacher_information,Integer> {

    @Modifying
    @Transactional
    @Query("DELETE FROM Teacher_information where id = ?1")
    public void deleteByTeacher_id(Integer id);

    //修改学生信息
    @Modifying
    @Transactional
    @Query("UPDATE Teacher_information n set n.teacher_id=?1 ,n.class_id=?2,n.teacher_name=?3,n.teacher_position=?4,n.teacher_sex=?5,n.teacher_age=?6 where id =?7")
    void updateByTeacher_id(Integer teacher_id,Integer class_id,String teacher_name,String teacher_position,String teacher_sex,Integer teacher_age,Integer id);

}
