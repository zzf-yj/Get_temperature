package com.health.repository;

import com.health.domain.Stu_information;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface Stu_inRepository extends JpaRepository<Stu_information,String> {

    //通过卡号来查询
    @Query("select n  from Stu_information n where n.student_card=?1")
    public List<Stu_information> findByCard(String student_card);

    //通过学号来查询
    @Query("select n  from Stu_information n where n.student_id=?1")
    public List<Stu_information> findByStuId(Integer student_id);

    //删除学生信息
    @Modifying
    @Transactional
    @Query("DELETE FROM Stu_information where id = ?1")
    void deleteByStu_id(Integer id);

    //修改学生信息
    @Modifying
    @Transactional
    @Query("UPDATE Stu_information n set n.student_id=?1 ,n.class_id=?2,n.student_card=?3,n.student_name=?4,n.student_sex=?5,n.student_age=?6 where id =?7")
    void updateByStu_id(Integer student_id,Integer class_id,String student_card,String student_name,String studen_sex,Integer student_age,Integer id);

}
