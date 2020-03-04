package com.codegym.restfulwebservices.service;


import com.codegym.restfulwebservices.bean.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoHardcodedService {

    private static List<Todo> todos = new ArrayList();
    private static long idCounter = 0;

    static {
        todos.add(new Todo(++idCounter,"kien","Learning English", new Date(), false));
        todos.add(new Todo(++idCounter,"kien","Learning Microservice", new Date(), false));
        todos.add(new Todo(++idCounter,"kien","Learning Python", new Date(), false));
    }

    public List<Todo> findAll(){
        return todos;
    }

    public Todo save(Todo todo){
        if(todo.getId() == -1 || todo.getId() == 0){
            todo.setId(++idCounter);
            todos.add(todo);
        } else {
            deleleById(todo.getId());
            todos.add(todo);
        }
        return todo;
    }

    public Todo deleleById(long id){
        Todo todo = findbyId(id);
        if(todo == null){
            return null;
        }

        if(todos.remove(todo)){
            return todo;
        }
        return null;
    }

    public Todo findbyId(long id){
        for(Todo todo : todos){
            if(todo.getId() == id ){
                return todo;
            }
        }
        return null;
    }
}
