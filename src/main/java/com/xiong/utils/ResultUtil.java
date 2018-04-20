package com.xiong.utils;

import com.xiong.domain.Result;

public class ResultUtil {
    public static Result success(Object object){
        Result result=new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }
    public static Result success(){
        return success(null);
    }
    public static Result error(Integer code,String message){
        Result result =new Result();
        result.setMsg(message);
        result.setCode(code);
        return result;
    }
}
