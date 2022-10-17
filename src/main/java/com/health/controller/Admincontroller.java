package com.health.controller;

import com.health.domain.*;
import com.health.repository.*;
import com.health.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
public class Admincontroller {
    /*
     * 1、添加教师信息
     * 2、添加班级信息
     * 3、添加学生信息
     * 4、查询所有学生信息
     * 5、查询所有班级信息
     * 6、查询所有教师信息
     */

    @Autowired
    private Stu_inRepository stu_inRepository;

    @Autowired
    private Class_inRepository class_inRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    //新增一名学生
    @PostMapping(value="/health/add/stu")
    public Result<Stu_information> stuAdd(@Valid Stu_information stu_information,
                                          BindingResult bindingResult){
        Result result = new Result();

        if (bindingResult.hasErrors()){
            return  ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        stu_information.setClass_id(stu_information.getClass_id());
        stu_information.setStudent_age(stu_information.getStudent_age());
        stu_information.setStudent_card(stu_information.getStudent_card());
        stu_information.setStudent_id(stu_information.getStudent_id());
        stu_information.setStudent_name(stu_information.getStudent_name());
        stu_information.setStudent_sex(stu_information.getStudent_sex());

        return ResultUtil.success(stu_inRepository.save(stu_information));
    }

    //新增一名班级
    @PostMapping(value="/health/add/class")
    public Result<Class_information> classAdd(@Valid Class_information class_information,
                                              BindingResult bindingResult){

        Result result = new Result();
        if (bindingResult.hasErrors()){
            return  ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        class_information.setClass_id(class_information.getClass_id());
        class_information.setClass_name(class_information.getClass_name());
        class_information.setClass_num(class_information.getClass_num());
        class_information.setTeacher_id(class_information.getTeacher_id());
        return ResultUtil.success(class_inRepository.save(class_information));
    }
    //新增一个教师
    @PostMapping(value="/health/add/teacher")
    public Result<Teacher_information> teacherAdd(@Valid Teacher_information teacher_information,
                                                  BindingResult bindingResult){
        Result result = new Result();

        if (bindingResult.hasErrors()){
            return  ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        teacher_information.setTeacher_id(teacher_information.getTeacher_id());
        teacher_information.setTeacher_name(teacher_information.getTeacher_name());
        teacher_information.setTeacher_sex(teacher_information.getTeacher_sex());
        teacher_information.setTeacher_age(teacher_information.getTeacher_age());
        teacher_information.setTeacher_position(teacher_information.getTeacher_position());
        teacher_information.setClass_id(teacher_information.getClass_id());
        return ResultUtil.success(teacherRepository.save(teacher_information));
    }

    //删除一个班级
    @PostMapping(value="/health/delete/class")
    public Result<Class_information> classDelete(@Valid Average average,
                                                 @RequestParam("id") String id,
                                                 BindingResult bindingResult){
        Result result = new Result();

        if (bindingResult.hasErrors()){
            return  ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        Integer ID = Integer.valueOf(id);
        class_inRepository.deleteByClass_id(ID);
        return ResultUtil.success_de();
    }
    //删除一个教师
    @PostMapping(value="/health/delete/teacher")
    public Result teacherDelete(@Valid Average average,
                                @RequestParam("id") Integer id,
                                BindingResult bindingResult){
        Result result = new Result();

        if (bindingResult.hasErrors()){
            return  ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }

        teacherRepository.deleteByTeacher_id(id);
        return ResultUtil.success_de();
    }
    //删除一个学生
    @PostMapping(value="/health/delete/stu")
    public Result stuDelete(@Valid Average average,
                            @RequestParam("id") Integer id,
                            BindingResult bindingResult){
        Result result = new Result();

        if (bindingResult.hasErrors()){
            return  ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        stu_inRepository.deleteByStu_id(id);
        return ResultUtil.success_de();
    }

    //查询所有学生
    @GetMapping(value = "/health/stu/getAll")
    public List<Stu_information> stuList(){
        return stu_inRepository.findAll();
    }
    //查询所有班级
    @GetMapping(value = "/health/class/getAll")
    public List<Class_information> classList(){
        return class_inRepository.findAll();
    }
    //查询所有教师
    @GetMapping(value = "/health/teacher/getAll")
    public List<Teacher_information> teacherList(){
        return teacherRepository.findAll();
    }

    //修改学生信息
    @PostMapping(value="/health/update/stu")
    public Result stuUpdate(@Valid Average average,
                            @RequestParam("id") Integer id,
                            @RequestParam("student_id") Integer student_id,
                            @RequestParam("student_card") String student_card,
                            @RequestParam("class_id") Integer class_id,
                            @RequestParam("student_name") String student_name,
                            @RequestParam("student_sex") String student_sex,
                            @RequestParam("student_age") Integer student_age,
                            BindingResult bindingResult){

        Result result = new Result();

        if (bindingResult.hasErrors()){
            return  ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        stu_inRepository.updateByStu_id(student_id,class_id,student_card,student_name,student_sex,student_age,id);
        return ResultUtil.success_up();
    }
    //修改老师信息
    @PostMapping(value="/health/update/teacher")
    public Result teacherUpdate(@Valid Average average,
                                @RequestParam("id") Integer id,
                                @RequestParam("teacher_id") Integer  teacher_id,
                                @RequestParam("teacher_name") String teacher_name,
                                @RequestParam("teacher_sex") String teacher_sex,
                                @RequestParam("teacher_age") Integer teacher_age,
                                @RequestParam("teacher_position") String teacher_position,
                                @RequestParam("class_id") Integer class_id,
                                BindingResult bindingResult){
        Result result = new Result();

        if (bindingResult.hasErrors()){
            return  ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        teacherRepository.updateByTeacher_id(teacher_id,class_id,teacher_name,teacher_position,teacher_sex,teacher_age,id);
        return ResultUtil.success_up();
    }
    //修改班级信息
    @PostMapping(value="/health/update/class")
    public Result classUpdate(@Valid Average average,
                              @RequestParam("class_id") Integer class_id,
                              @RequestParam("class_name") String class_name,
                              @RequestParam("class_num") Integer class_num,
                              @RequestParam("teacher_id") Integer teacher_id,
                              @RequestParam("id") Integer id,
                              BindingResult bindingResult){
        Result result = new Result();
        if (bindingResult.hasErrors()){
            return  ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        class_inRepository.updateByStu_id(class_id,class_name,class_num,teacher_id,id);
        return ResultUtil.success_up();
    }
}
