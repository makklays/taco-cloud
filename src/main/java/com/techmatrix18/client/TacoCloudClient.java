package com.techmatrix18.client;

import com.techmatrix18.model.Ingredient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class TacoCloudClient {

    private final RestTemplate rest;

    public TacoCloudClient(RestTemplate rest) {
        this.rest = rest;
    }

    // get
    public Ingredient getIngredientById(String ingredientId) {
        return rest.getForObject(
                "http://localhost:8081/ingredients/{id}",
                Ingredient.class,
                ingredientId
        );
    }

    public Ingredient getIngredientById2(String ingredientId) {
        Map<String, String> urlVariables = new HashMap<>();
        urlVariables.put("id", ingredientId);
        return rest.getForObject(
                "http://localhost:8081/ingredients/{id}",
                Ingredient.class,
                urlVariables
        );
    }

    public Ingredient getIngredientById3(String ingredientId) {
        Map<String, String> urlVariables = new HashMap<>();
        urlVariables.put("id", ingredientId);
        URI url = UriComponentsBuilder
                .fromHttpUrl("http://localhost:8081/ingredients/{id}")
                .build(urlVariables);
        return rest.getForObject(url, Ingredient.class);
    }

    public Ingredient getIngredientById4(String ingredientId) {
        ResponseEntity<Ingredient> responseEntity = rest.getForEntity(
                "http://localhost:8081/ingredients/{id}",
                Ingredient.class,
                ingredientId
        );
        log.info("Fetched time: {}" + responseEntity.getHeaders().getDate());
        return responseEntity.getBody();
    }

    // put
    public void updateIngredient(Ingredient ingredient) {
        rest.put("http://localhost:8081/ingredients/{id}", ingredient, ingredient.getId());
    }

    // delete
    public void deleteIngredient(Ingredient ingredient) {
        rest.delete("http://localhost:8081/ingredients/{id}", ingredient.getId());
    }

    // post
    public Ingredient createIngredient(Ingredient ingredient) {
        return rest.postForObject("http://localhost:8081/ingredients", ingredient, Ingredient.class);
    }

    public java.net.URI createIngredient2(Ingredient ingredient) {
        return rest.postForLocation("http://localhost:8081/ingredients", ingredient);
    }

    public Ingredient createIngredient3(Ingredient ingredient) {
        ResponseEntity<Ingredient> responseEntity = rest.postForEntity(
                "http://localhost:8081/ingredients",
                ingredient,
                Ingredient.class
        );
        log.info("New resource created at: {}" + responseEntity.getHeaders().getLocation());
        return responseEntity.getBody();
    }
}

