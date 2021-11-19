package com.springbytes.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.springbytes.model.ShoppingCart;
import com.springbytes.repository.ShoppingCartRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/basket")
public class ShoppingCartController {

    private final ShoppingCartRepository shoppingCartRepository;

    public ShoppingCartController(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }

    @GetMapping("/{username}")
    public ShoppingCart getBasket(@PathVariable("username") String username) {
        return shoppingCartRepository.getShoppingCartByUserName(username);
    }

    @PutMapping
    public ShoppingCart updateBasket(@RequestBody ShoppingCart shoppingCart) throws JsonProcessingException {
        return shoppingCartRepository.updateShoppingCart(shoppingCart);
    }

    @DeleteMapping("/{username}")
    public void deleteBasket(@PathVariable("username") String username) {
        shoppingCartRepository.deleteShoppingCart(username);
    }
}
