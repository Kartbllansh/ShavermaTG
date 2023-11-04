package com.chaverma.dto;

import com.shaverma.database.entity.Menu;
import lombok.Builder;

@Builder
public record MenuDTO(
        String typeDish, String nameDish, Double price, Long calories
) {
    public Menu toEntity() {
        return Menu.builder()
                .typeDish(typeDish)
                .nameDish(nameDish)
                .price(price)
                .calories(calories)
                .build();
    }
}
