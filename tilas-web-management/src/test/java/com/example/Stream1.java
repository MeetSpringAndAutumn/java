package com.example;

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 生成新类/接口/枚举
 *
 * @Author: shanzhengshuai
 * @Description:
 * @Date: 2024/10/30
 */

public class Stream1 {
    public static  void main(String[] args) {

        ArrayList<String> list=new ArrayList<>();
//        Collections.addAll(list,"张无忌-男-15","周芷若-女-14","赵敏-女-13","张强-男-20",
//                "张三丰-男-100","张翠山-男-40","张良-男-35","王二麻子-男-37","谢广坤-男-41");
//        list.stream().filter(s->s.contains("张")).forEach(System.out::println);
//        for(int i = 0; i < 10; i++) {
//            list.add(i);
//        }
//        list.stream().filter(s->s%2==0).forEach(System.out::println);
//        List<Integer> newList = list.stream().filter(s -> s % 2 == 0).collect(Collectors.toList());
//        newList.forEach(System.out::println);
//        Collections.addAll(list,"zhangsan,23","lisi,24","Wangwu,25");
//        Map<String, Integer> collect = list.stream().filter(s -> Integer.parseInt(s.split(",")[1]) >= 24)
//                .collect(Collectors.toMap(s -> s.split(",")[0], s -> Integer.parseInt(s.split(",")[1])));
//        System.out.println(collect);
        List<String> maleActors = new ArrayList<>();
        Collections.addAll(maleActors,
                "张三,30",
                "李s四,35",
                "王s五,28",
                "赵六,40",
                "钱s七,32",
                "孙八,29"
        );

        // 存储女演员的集合
        List<String> femaleActors = new ArrayList<>();
        Collections.addAll(femaleActors,
                "李丽,25",
                "杨芳,27",
                "张燕,31",
                "杨静,29",
                "钱霞,33",
                "孙美,26"
        );
        List<Actor> c =Stream.concat(maleActors.stream()
                                .filter(s -> s.split(",")[0].length() == 3)
                                .limit(2),
                        femaleActors.stream()
                                .filter(s -> s.startsWith("杨"))
                                .skip(1)
                )
                .map(s -> new Actor(s.split(",")[0], Integer.parseInt(s.split(",")[1])))
                .collect(Collectors.toList());
            System.out.println(c);
    }
}
