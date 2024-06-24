package com.hexagonal.tasks.infrastructure.adapters;

import com.hexagonal.tasks.domain.models.AdditionalTasksInfo;
import com.hexagonal.tasks.domain.ports.output.ExternalServicePort;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ExternalServiceAdapter implements ExternalServicePort {

    private final RestTemplate restTemplate;

    public ExternalServiceAdapter(){
        this.restTemplate =  new RestTemplate();
    }

    @Override
    public AdditionalTasksInfo getAdditionalTasksInfo(Long id) {

        String apiUrlTodos = "https://jsonplaceholder.typicode.com/todos/" + id;
        ResponseEntity<JsonPlaceHolderTodo> todoResponse = restTemplate
                .getForEntity(apiUrlTodos, JsonPlaceHolderTodo.class);
        JsonPlaceHolderTodo todo = todoResponse.getBody();
        if (todo == null) {
            return null;
        }

        String apiUrlUserId = "https://jsonplaceholder.typicode.com/users/" + todo.getUserId();
        ResponseEntity<JsonPlaceHolderUser> userResponse = restTemplate
                .getForEntity(apiUrlUserId, JsonPlaceHolderUser.class);

        JsonPlaceHolderUser user = userResponse.getBody();

        if (user == null) {
            return null;
        }

        return new AdditionalTasksInfo(user.getId(), user.getUsername(), user.getEmail());
    }

    @Getter
    @Setter
    private static class JsonPlaceHolderTodo {
        private Long id;
        private Long userId;
    }

    @Getter
    @Setter
    private static class JsonPlaceHolderUser {
        private Long id;
        private String username;
        private String email;
    }
}
