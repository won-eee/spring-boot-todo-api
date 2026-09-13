package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodoController {
    private final TodoRepository todoRepository;

    public TodoController(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    @GetMapping
    public List<Todo> getTodos() {
        return todoRepository.findAll();
    }

    @PostMapping
    public Todo addTodo(@RequestParam String title) {
        Todo todo = new Todo(title, false);
        return todoRepository.save(todo);
    }

    @PutMapping("/{id}")
    public Todo toggleTodo(@PathVariable Long id){
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 id의 할 일이 없습니다:" + id));

        todo.setCompleted(!todo.isCompleted());
        return todoRepository.save(todo);
    }

    @DeleteMapping("/{id}")
    public String deleteTodo(@PathVariable Long id){
        todoRepository.deleteById(id);
        return id + "번 할 일이 삭제되었습니다.";
    }
}