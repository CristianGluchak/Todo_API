package br.com.crud_todo_list.controller;

import br.com.crud_todo_list.entity.Todo;
import br.com.crud_todo_list.service.TodoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Cristian Gluchak <cjgc4002@gmail.com>
 * @since 20/11/2024
 */
@RestController
@RequestMapping("/todo")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping
    List<Todo> create(@RequestBody @Valid Todo todo) {
        return todoService.create(todo);
    }

    @GetMapping
    List<Todo> list() {
        return todoService.list();
    }

    @PutMapping
    List<Todo> update(@RequestBody Todo todo) {
        return todoService.update(todo);
    }

    @DeleteMapping("{id}")
    List<Todo> deleteById(@PathVariable("id") Long id) {
        return todoService.deleteById(id);
    }
}
