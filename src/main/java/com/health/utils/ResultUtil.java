package com.health.utils;

import com.health.domain.Result;

public class ResultUtil {

    public static Result success(Object object){
        Result result = new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    public static Result success_up(){
        Result result = new Result();
        result.setCode(1);
        result.setMsg("修改成功");
        return result;
    }

    public static Result success_de(){
        Result result = new Result();
        result.setCode(2);
        result.setMsg("删除成功");
        return result;
    }

    public static Result success_go(){
        Result result = new Result();
        result.setCode(3);
        result.setMsg("登录成功");
        return result;
    }

    public static Result error_go(){
        Result result = new Result();
        result.setCode(3);
        result.setMsg("登录失败");
        return result;
    }

    public static Result success(){
        return success(null);
    }

    public static Result error(Integer code, String msg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
