package com.springbytes.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.springbytes.model.ShoppingCart;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ShoppingCartRepository {

    private static final String KEY = "SHOPPING-CART";

    private final HashOperations<String, String, ShoppingCart> hashOperations;
    private final ObjectMapper objectMapper;

    public ShoppingCartRepository(RedisTemplate<String, ShoppingCart> redisTemplate, ObjectMapper objectMapper) {
        this.hashOperations = redisTemplate.opsForHash();
        this.objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
    }

    public ShoppingCart getShoppingCartByUserName(String userName) {
        return hashOperations.get(KEY, userName);
    }

    public ShoppingCart updateShoppingCart(ShoppingCart shoppingCart) throws JsonProcessingException {
        hashOperations.put(KEY, shoppingCart.getUsername(), shoppingCart);
        return hashOperations.get(KEY, shoppingCart.getUsername());
    }

    public void deleteShoppingCart(String username) {
        hashOperations.delete(KEY, username);
    }
}
