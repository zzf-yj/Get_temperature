package com.health.controller;

import com.health.domain.Average;
import com.health.domain.Result;
import com.health.domain.Stu_information;
import com.health.domain.User;
import com.health.repository.UserRepository;
import com.health.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class Usercontroller {

    @Autowired
    private UserRepository userRepository;

    //查询单个学生-通过ID
    @PostMapping(value = "/health/user")
    public Result UserFindOne(@Valid Average average,
                               @RequestParam("account")   String account,
                               @RequestParam("password")  String password,
                               @RequestParam("identity")  String identity,
                               BindingResult bindingResult){

        Result result = new Result();

        if (bindingResult.hasErrors()){
            return  ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        List list = userRepository.findByUser(account,password,identity);
        if(list!=null && !list.isEmpty()){
            return ResultUtil.success_go();
        }else{
            return ResultUtil.error_go();
        }
    }

    @PostMapping(value = "/health/user1")
    public List classFind(@RequestParam("account")   String account,
                          @RequestParam("password")  String password,
                          @RequestParam("identity")  String identity){
        List list = userRepository.findByUser(account,password,identity);
        return list;
    }

    //新增一名用户
    @PostMapping(value="/health/add/user")
    public Result<User> stuAdd(@Valid User user,
                               BindingResult bindingResult){
        Result result = new Result();

        if (bindingResult.hasErrors()){
            return  ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        user.setAccount(user.getAccount());
        user.setPassword(user.getPassword());
        user.setIdentity(user.getIdentity());
        user.setStudent_id(user.getStudent_id());
        user.setClass_id(user.getClass_id());
        return ResultUtil.success(userRepository.save(user));
    }
}
