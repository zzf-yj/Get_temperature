package com.health.controller;

import com.health.domain.*;
import com.health.repository.*;
import com.health.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@RestController
public class Studentcontorller {

    /*
     *增删改查
     * 1、查询单个学生的信息->student_number
     * 2、添加登记信息->class_register
     * 3、添加请假信息-> student_leave,class_leaver
     * 4、查询请假处理结果信息->class_leaver
     */
    @Autowired
    private Stu_numRepository stu_numRepository;
    @Autowired
    private Stu_inRepository stu_inRepository;
    @Autowired
    private Class_leaverRepository class_leaverRepository;
    @Autowired
    private Class_reRepository class_reRepository;

    //查询单个学生信息
    @GetMapping(value = "/health/stu/get/one")
    public List<Stu_number> stuList(){
        return stu_numRepository.findAll();
    }

    //添加登记信息
    @PostMapping(value="/health/stu/add/register")
    public Result<Class_register> stuAdd(@Valid Class_register class_register, BindingResult bindingResult){
        Result result = new Result();

        if (bindingResult.hasErrors()){
            return  ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }

        Date date = new Date();
        class_register.setStudent_id(class_register.getStudent_id());
        class_register.setClass_id(class_register.getClass_id());
        class_register.setStudent_name(class_register.getStudent_name());
        class_register.setStudent_sex(class_register.getStudent_sex());
        class_register.setStudent_temp(class_register.getStudent_temp());
        class_register.setDate(date);
        class_register.setLocation1(class_register.getLocation1());
        class_register.setLocation2(class_register.getLocation2());
        class_register.setLocation3(class_register.getLocation3());
        return ResultUtil.success(class_reRepository.save(class_register));
    }
    //添加请假信息
    @PostMapping(value = "/health/stu/add/leaver")
    public Result stu_leavedd(@Valid Class_leaver class_leaver,
                               @RequestParam("student_id") Integer  student_id,
                               @RequestParam("student_temp") String student_temp,
                               @RequestParam("reason") String reason,
                               BindingResult bindingResult) {
        Result result = new Result();

        if (bindingResult.hasErrors()) {
            return ResultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }

        Integer class_id = 0;
        String  student_name = null;
        String  student_sex = null;
        Date date = new Date();

        List list = stu_inRepository.findByStuId(student_id);

        for (int i = 0; i < list.size(); i++) {
            Stu_information bean = (Stu_information) list.get(i);
            class_id = bean.getClass_id();
            student_name = bean.getStudent_name();
            student_sex = bean.getStudent_sex();
        }
        class_leaver.setStudent_id(student_id);
        class_leaver.setClass_id(class_id);
        class_leaver.setStudent_name(student_name);
        class_leaver.setStudent_name(student_name);
        class_leaver.setStudent_sex(student_sex);
        class_leaver.setStudent_temp(student_temp);
        class_leaver.setDate(date);
        class_leaver.setReason(reason);
        return ResultUtil.success(class_leaverRepository.save(class_leaver));
    }

    //查询请假处理结果信息
    @GetMapping(value = "/health/stu/get/leaver")
    public List<Class_leaver> stu_leaverList(@RequestParam("student_id") Integer student_id){
        return class_leaverRepository.findByStuID(student_id);
    }

    //查询请假信息
    @GetMapping(value = "/health/class/get/leaver")
    public List<Class_leaver> class_leaverList(){
        return class_leaverRepository.findAll();
    }
    //查询外出登记信息
    @GetMapping(value = "/health/class/get/register")
    public List<Class_register> class_registerList(){
        return class_reRepository.findAll();
    }
}
