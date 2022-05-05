package com.fc.exception;

// 自定义单身狗异常
public class SingletonException extends Exception{
    //无参构造方法
    public SingletonException(){
        super();
    }

    //有参构造方法
    public SingletonException(String message) {
        super(message);
    }
}
