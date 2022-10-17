package com.health.controller;

import com.google.gson.Gson;
import com.health.domain.Class_number;
import com.health.domain.Result;
import com.health.domain.Stu_information;
import com.health.domain.Stu_number;
import com.health.repository.Class_inRepository;
import com.health.repository.Class_numRepository;
import com.health.repository.Stu_inRepository;
import com.health.repository.Stu_numRepository;
import com.health.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.Console;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang.StringUtils;

@Slf4j
@RestController
public class uploadDatacontroller {

    @Autowired
    private Class_numRepository class_numRepository;

    @Autowired
    private Stu_inRepository stu_inRepository;

    @Autowired
    private Stu_numRepository stu_numRepository;
    /*
     *1、通过查询找到对应学生
     *2、将查询的数据，结合接收的数据一起添加到class-number表
     *3、将数据传到学生自己的表
     */
    @PostMapping(value = "/health/upload/{student_card}/{student_temp}")
    public Result stuFindONe(@Valid Class_number class_number,
                             @PathVariable("student_card") String student_card,
                             @PathVariable("student_temp") String student_temp,
                             BindingResult bindingResult)
    {

        log.info(student_card);
        log.info(student_temp);
        Stu_number stu_number = new Stu_number();
        Integer class_id = 0;
        Integer student_id = 0;
        String student_name = null;
        String student_sex= null;

        Result result = new Result();
        if (bindingResult.hasErrors()){
            return  ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }

        Date date = new Date();
        List list =  stu_inRepository.findByCard(student_card);
        //需要做一个判断
        for (int i = 0; i < list.size(); i++)
        {
            Stu_information bean = (Stu_information) list.get(i);
            class_id = bean.getClass_id();
            student_id = bean.getStudent_id();//这样就获取到值了
            student_name = bean.getStudent_name();
            student_sex = bean.getStudent_sex();
        }
        class_number.setClass_id(class_id);
        class_number.setStudent_id(student_id);
        class_number.setStudent_name(student_name);
        class_number.setStudent_sex(student_sex);
        class_number.setStudent_temp(student_temp);
        class_number.setStudent_data(date);
        stu_number.setDate(date);
        stu_number.setTemp(student_temp);

        stu_numRepository.save(stu_number);
        return ResultUtil.success(class_numRepository.save(class_number));
    }


}
