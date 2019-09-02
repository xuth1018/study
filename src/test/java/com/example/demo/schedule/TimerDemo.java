package com.example.demo.schedule;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.demo.builder.NutritionFacts;
import sun.security.jca.GetInstance;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.*;

public class TimerDemo {

    public static void main(String[] args) {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("执行任务："+ LocalDateTime.now());
            }
        };
        Timer timer = new Timer();

        timer.schedule(timerTask,5000,3000);

        NutritionFacts nutri = new NutritionFacts.Builder(240,80)
                .calories(12).carbohydrate(2).fat(4).sodium(6).build();
        System.out.println(nutri);
    }

}

class Student{
    private String name;
    private String id;
    public static Student student(String name,String id){
        return new Student(name,id);
    }
    public Student(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
