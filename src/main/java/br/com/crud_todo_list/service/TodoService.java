package br.com.crud_todo_list.service;

import br.com.crud_todo_list.entity.Todo;
import br.com.crud_todo_list.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Cristian Gluchak <cjgc4002@gmail.com>
 * @since 05/11/2024
 */
@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository repository;

    public List<Todo> create(Todo todo) {
        repository.save(todo);
        return list();
    }

    public List<Todo> list() {
        Sort criterioPesquisa = Sort.by("priority").descending().and(Sort.by("name").ascending());
        return repository.findAll(criterioPesquisa);
    }

    public List<Todo> update(Todo todo) {
        repository.save(todo);
        return list();
    }

    public List<Todo> deleteById(final Long id) {
    repository.deleteById(id);
        return list();
    }

}
