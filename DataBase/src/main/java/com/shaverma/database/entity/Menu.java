package com.shaverma.database.entity;

import com.chaverma.dto.MenuDTO;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode(exclude = "id")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "AppUser")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String typeDish;
    private String nameDish;
    private Double price;
    private Long calories;

    public MenuDTO toDTO(){
        return MenuDTO.builder()
                .typeDish(typeDish)
                .nameDish(nameDish)
                .price(price)
                .calories(calories).build();

    }

}
