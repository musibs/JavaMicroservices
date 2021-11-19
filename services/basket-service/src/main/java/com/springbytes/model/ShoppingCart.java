package com.springbytes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class ShoppingCart extends JdkSerializationRedisSerializer implements Serializable {

    private static final long serialVersionUID = 1L;

    private String username;
    private List<ShoppingCartItem> items = new ArrayList<>();

    @JsonIgnore
    public BigDecimal totalCartPrice() {
        BigDecimal sum = new BigDecimal(0);
        items.stream().forEach(item -> sum.add(BigDecimal.valueOf(item.getPrice() * item.getQuantity()))) ;
        return sum;
    }


}
