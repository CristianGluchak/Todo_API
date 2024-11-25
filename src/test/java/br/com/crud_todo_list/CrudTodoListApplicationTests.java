package br.com.crud_todo_list;

import br.com.crud_todo_list.entity.Todo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class CrudTodoListApplicationTests {

	@Autowired
	private WebTestClient webTestClient;

	@Test
	void testCreateTodoSucces() {
		var todo=new Todo("todo 1","descricao todo 1",false,2);

		webTestClient
				.post()
				.uri("/todo")
				.bodyValue(todo)
				.exchange()
				.expectStatus().isOk()
				.expectBody()
				.jsonPath("$").isArray()
				.jsonPath("$.length()").isEqualTo(1)
				.jsonPath("$[0].name").isEqualTo(todo.getName())
				.jsonPath("$[0].description").isEqualTo(todo.getDescription())
				.jsonPath("$[0].done").isEqualTo(todo.isDone())
				.jsonPath("$[0].priority").isEqualTo(todo.getPriority())
		;
	}

	@Test
	void testCreateTodoFailure() {
		webTestClient
				.post()
				.uri("/todo")
				.bodyValue(new Todo("","",false,0))
				.exchange()
				.expectStatus().isBadRequest();
	}
}
