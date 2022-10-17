package com.health.controller;

import com.health.domain.*;
import com.health.repository.Class_leaverRepository;
import com.health.repository.Class_numRepository;
import com.health.repository.Class_reRepository;
import com.health.utils.ResultUtil;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@RestController
public class Classcontorller {

    /*
     *增删改查
     * 1、获取本班所有学生的当天的信息-class_id
     * 2、查询单个学生->通过学号student-id,和class_id
     * 3、获取登记信息
     * 4、获取请假信息
     *    1、查找
     *    2、修改
     */

    @Autowired
    private Class_numRepository class_numRepository;

    @Autowired
    private Class_reRepository class_reRepository;

    @Autowired
    private Class_leaverRepository class_leaverRepository;

    //查询所有学生-通过ID
    @PostMapping(value = "/health/getclass")
    public List classFindAll(@RequestParam("class_id") Integer class_id){

        List list = class_numRepository.findByClassID(class_id);
        return list;
    }

    //查询五个学生-通过ID
    Pageable pageable = PageRequest.of(0,5);
    @PostMapping(value = "/health/getclass/Five")
    public List classFindFive(@RequestParam("class_id") Integer class_id){

        List list = class_numRepository.findByClassIDF(class_id,pageable);
        return list;
    }

    //查询单个学生-通过ID
    @PostMapping(value = "/health/getclass/getone")
    public List classFindOne(@RequestParam("student_id") Integer student_id){

        List list = class_numRepository.findByOne(student_id);
        return list;
    }

    //查询学生_通过性别
    @PostMapping(value = "/health/getclass/getSex")
    public List classFindSex(@RequestParam("student_sex")  String student_sex){

        List list = class_numRepository.findBySex(student_sex);
        return list;
    }

    //查询所有学生体温信息
    @PostMapping(value = "/health/getclass/getAll")
    public List classFindAll(){

        List list = class_numRepository.findAll();
        return list;
    }

    Pageable pageable1 = PageRequest.of(0,10);
    //查询前10的学生体温信息
    @PostMapping(value = "/health/getclass/Temp")
    public List classFindTemp(){
        List list = class_numRepository.findByTemp(pageable1);
        return list;
    }

    //查询登记信息->t通过ID
    @GetMapping(value = "/health/getclass/getregister")
    public List classFindRe(@RequestParam("class_id") Integer class_id){

        List list = class_reRepository.findByClassID(class_id);
        return list;
    }

    //查询请假信息->t通过ID
    @GetMapping(value = "/health/getclass/getleaver")
    public List classFindLeaver(@RequestParam("class_id") Integer class_id){

        List list = class_leaverRepository.findByClassID(class_id);
        return list;
    }

    //更改请假信息
    @GetMapping(value = "/health/getclass/leaver")
    public Result classUpdateLeaver(@Valid Class_leaver class_leaver,
                                    @RequestParam("student_id") Integer student_id,
                                    @RequestParam("authorize")  String authorize,
                                    BindingResult bindingResult)
    {
        Integer id  = 0;
        Integer class_id = 0;
        String student_name = null;
        String student_sex = null;
        String student_temp = null;
        String reason = null;
        Date date = new Date();

        Result result = new Result();
        if (bindingResult.hasErrors()){
            return  ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }

        List list =  class_leaverRepository.findByOne(student_id);
        System.out.println(list);
        for (int i = 0; i < list.size(); i++)
        {
            Class_leaver bean = (Class_leaver) list.get(i);
            id = bean.getId();
            class_id = bean.getClass_id();
            student_name = bean.getStudent_name();
            student_sex = bean.getStudent_sex();
            student_temp = bean.getStudent_temp();
            date = bean.getDate();
            reason = bean.getReason();
        }

        class_leaver.setId(id);
        class_leaver.setClass_id(class_id);
        class_leaver.setStudent_id(student_id);
        class_leaver.setStudent_name(student_name);
        class_leaver.setStudent_sex(student_sex);
        class_leaver.setStudent_temp(student_temp);
        class_leaver.setDate(date);
        class_leaver.setReason(reason);
        class_leaver.setAuthorize(authorize);

        return ResultUtil.success(class_leaverRepository.save(class_leaver));
    }

}
