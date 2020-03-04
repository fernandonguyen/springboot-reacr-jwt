package com.codegym.restfulwebservices.controller;

import com.codegym.restfulwebservices.bean.Todo;
import com.codegym.restfulwebservices.service.TodoHardcodedService;
import com.codegym.restfulwebservices.service.TodoJpaService;
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
public class TodoJpaResource {

    private static final Logger logger = LoggerFactory.getLogger(TodoJpaResource.class);

    @Autowired
    private TodoJpaService todoJpaService;

    @Autowired
    private TodoHardcodedService todoHardcodedService;

    @GetMapping("/jpa/user/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable String username) {
        return todoJpaService.findByUsername(username);
       // return todoHardcodedService.findAll();
    }

    @DeleteMapping("/jpa/user/{username}/todos/{id}")
    public ResponseEntity<Void> deletedById(@PathVariable String username, @PathVariable long id){
        todoJpaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/jpa/user/{username}/todos/{id}")
    public ResponseEntity<Todo> updateById(@PathVariable String username, @PathVariable long id, @RequestBody Todo todo){
        todo.setUsername(username);
        Todo newTodo = todoJpaService.save(todo);
        return new ResponseEntity<Todo>(todo, HttpStatus.OK);
    }

    @PostMapping("/jpa/user/{username}/todos")
    public ResponseEntity<Void> createTodo(@PathVariable String username, @RequestBody Todo todo) {
        todo.setUsername(username);
        Todo createTodo = todoJpaService.save(todo);
        //get Uri
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createTodo.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/jpa/user/{username}/todos/{id}")
    public Todo getTodo(@PathVariable String username, @PathVariable long id) {
        Todo todo = todoJpaService.findById(id).get();
       //Todo todo = todoHardcodedService.findbyId(id);
        return todo;
    }

}
