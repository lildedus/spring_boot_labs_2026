package ru.seleznev.MyFirstTestAppSpringBoot.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class Lab1 {

    private List<String> list;
    private Map<Integer, String> map;
    private int num = 1;

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    @GetMapping("/update-array")
    public String updateArrayList(@RequestParam(value = "s") String s) {
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(s);
        return "Добавлено в ArrayList: " + s;
    }

    @GetMapping("/show-array")
    public List<String> showArrayList() {
        if (list == null) {
            return new ArrayList<>();
        }
        return list;
    }

    @GetMapping("/update-map")
    public String updateHashMap(@RequestParam(value = "s") String s) {
        if (map == null) {
            map = new HashMap<>();
        }
        map.put(num, s);
        num++;
        return "Добавлено в HashMap: " + s;
    }

    @GetMapping("/show-map")
    public Map<Integer, String> showHashMap() {
        if (map == null) {
            return new HashMap<>();
        }
        return map;
    }

    @GetMapping("/show-all-lenght")
    public String showAllLenght() {
        int n = (list == null) ? 0 : list.size();
        int x = (map == null) ? 0 : map.size();
        return "Количество элементов в ArrayList: " + n + ", в HashMap: " + x;
    }
}