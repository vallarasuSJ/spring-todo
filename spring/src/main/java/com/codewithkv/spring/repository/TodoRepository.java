package com.codewithkv.spring.repository;

import com.codewithkv.spring.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TodoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;



    public List<Todo> findAll() {
        return jdbcTemplate.query("SELECT * FROM todo",new BeanPropertyRowMapper<>(Todo.class));
    }
    public Todo findById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM todo WHERE id=?;", new Object[]{id},new BeanPropertyRowMapper<>(Todo.class));
    }

    public List<Todo> insertItem(Todo todo) {
        jdbcTemplate.update("INSERT INTO todo (item) VALUES (?);",new Object[]{todo.getItem()});
        return findAll();
    }

    public List<Todo> updateItem(Todo todo) {
        jdbcTemplate.update("UPDATE todo SET item=? WHERE id=?;",new Object[]{todo.getItem(),todo.getId()});
        return findAll();
    }

    public List<Todo> deleteItemById(int id) {
        jdbcTemplate.update("DELETE FROM todo WHERE id=?;",new Object[]{id});
        return findAll();
    }
}
