package com.in28minutes.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//import org.apache.taglibs.standard.extra.spath.Predicate;
import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

import java.util.function.Predicate; 


@Service
public class TodoService {

    private static List<Todo> todos = new ArrayList<Todo>();
    private static int todoCount = 0;
    
    static{
        todos.add(new Todo(++todoCount, "in28minutes", "learnAWS",
                                LocalDate.now().plusYears(1),false));
        todos.add(new Todo(++todoCount, "in28minutes", "learndev",
                                LocalDate.now().plusYears(1),false));
        todos.add(new Todo(++todoCount, "in28minutes", "fallstack",
                                LocalDate.now().plusYears(1),false));
        
    }

    public List<Todo> findUsername(String username){
        Predicate <? super Todo> predicate= todo -> todo.getUsername().equalsIgnoreCase(username);
        return todos.stream().filter(predicate).toList();
    }

    public void addTodo(String username, String description, LocalDate date, boolean done){
        Todo todo = new Todo(++todoCount, username, description,date,done);
        todos.add(todo);
    }

    public void deleteByID(int id) {
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        todos.removeIf(predicate);
    }

    public Todo findById(int id) {
        Predicate<? super Todo> predicate = todo -> todo.getId() == id;
        Todo todo = todos.stream().filter(predicate).findFirst().get();
        return todo;
    }

    public void updateTodo(@Valid Todo todo) {
        deleteByID(todo.getId()); 
        todos.add(todo);
    }
}
