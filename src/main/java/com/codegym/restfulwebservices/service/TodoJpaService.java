package com.codegym.restfulwebservices.service;

import com.codegym.restfulwebservices.bean.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TodoJpaService extends JpaRepository<Todo,Long> {
    List<Todo>  findByUsername(String username);
}
