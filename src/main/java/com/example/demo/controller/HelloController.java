package com.example.demo.controller;

import com.example.demo.domain.TodoList;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
public class HelloController {

    private List<TodoList> todoLists = new ArrayList<>();

    public HelloController() {
        todoLists.add(new TodoList(UUID.randomUUID().toString(),"JAVA入门",false));
        todoLists.add(new TodoList(UUID.randomUUID().toString(),"区块链",false));
        todoLists.add(new TodoList(UUID.randomUUID().toString(),"比特币",false));
        todoLists.add(new TodoList(UUID.randomUUID().toString(),"web开发",false));
    }

    @GetMapping("/todo")
    public List<TodoList> get() {
        return todoLists;
    }

    @PostMapping("/todo")
    public TodoList post(@RequestParam String title) {
        TodoList todoList = new TodoList(title, false);
        todoLists.add(todoList);
        return todoList;
    }

    @PutMapping("/todo")
    public TodoList put(@RequestParam String id,@RequestParam String title,@RequestParam Boolean finished) {
        TodoList todoList = new TodoList(id, title, finished);
        todoLists = todoLists.stream()
                .map(v -> {
                    if (v.getId().equals(todoList.getId())) {
                        return todoList;
                    } else {
                        return v;
                    }
                }).collect(Collectors.toList());
        return todoList;
    }

}
