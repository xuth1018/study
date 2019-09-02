package com.example.demo;

import com.alibaba.fastjson.JSON;

public class JsonTest {
    public static void main(String[] args) {
        Son son = new Son();
        son.setAge(23);
        son.setName("网");
        String str = JSON.toJSONString(son);
        System.out.println(str);

        Son s1 = JSON.parseObject(str,son.getClass());
        System.out.println(s1);
    }


}

class Son {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}