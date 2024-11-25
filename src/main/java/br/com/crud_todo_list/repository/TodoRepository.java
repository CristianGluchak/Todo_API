package br.com.crud_todo_list.repository;

import br.com.crud_todo_list.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Cristian Gluchak <cjgc4002@gmail.com>
 * @since 05/11/2024
 */
public interface TodoRepository  extends JpaRepository<Todo,Long> {
}
