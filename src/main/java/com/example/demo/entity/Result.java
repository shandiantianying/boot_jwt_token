package com.example.demo.entity;

import lombok.Data;

@Data
public class Result<T> {
    private Integer code;
    private String message;
    private T data;

    public Result(){
        this.code = 200;
        this.message ="操作成功";
    }

    public Result(Integer code,String message){
        this.code = code;
        this.message = message;
    }

    public static  Result<String> error(Integer code,String msg){
        return  new Result<>(code,msg);
    }

    public Result(T data) {
        this.code = 200;
        this.message ="操作成功";
        this.data = data;
    }
}
