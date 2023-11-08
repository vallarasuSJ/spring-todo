package com.codewithkv.spring.Controller;

import com.codewithkv.spring.model.Todo;
import com.codewithkv.spring.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @GetMapping("/todo/all")
    public List<Todo> getAllTodo(){
        return todoRepository.findAll();
    }

    @GetMapping("/todo/{id}")
    public Todo getTodo(@PathVariable int id){
        return todoRepository.findById(id);
    }

    @PostMapping("/todo")
    public List<Todo> addTodo(@RequestBody Todo todo){
        return todoRepository.insertItem(todo);
    }

    @PutMapping("/todo")
    public List<Todo> updateTodo(@RequestBody Todo todo){
        return todoRepository.updateItem(todo);
    }

    @DeleteMapping("/todo/{id}")
    public List<Todo> deleteTodo(@PathVariable int id){
        return todoRepository.deleteItemById(id);
    }


}
