package com.codegym.restfulwebservices.controller;

import com.codegym.restfulwebservices.bean.Todo;
import com.codegym.restfulwebservices.service.TodoHardcodedService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TodoResource {

    private static final Logger logger = LoggerFactory.getLogger(TodoResource.class);

    @Autowired
    private TodoHardcodedService todoHardcodedService;

    @GetMapping("/user/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable String username) {
        return todoHardcodedService.findAll();
    }

    @DeleteMapping("/user/{username}/todos/{id}")
    public ResponseEntity<Void> deletedById(@PathVariable String username, @PathVariable long id){
        Todo todo = todoHardcodedService.deleleById(id);
        if(todo != null) {
           return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/user/{username}/todos/{id}")
    public ResponseEntity<Todo> updateById(@PathVariable String username, @PathVariable long id, @RequestBody Todo todo){
        Todo newTodo = todoHardcodedService.save(todo);
        return new ResponseEntity<Todo>(todo, HttpStatus.OK);
    }

    @PostMapping("/user/{username}/todos")
    public ResponseEntity<Void> updateTodo(@PathVariable String username, @RequestBody Todo todo) {
        Todo createTodo = todoHardcodedService.save(todo);
        //get Uri
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createTodo.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/user/{username}/todos/{id}")
    public Todo getTodo(@PathVariable String username, @PathVariable long id) {
        Todo todo = todoHardcodedService.findbyId(id);
        return todo;
    }

}
