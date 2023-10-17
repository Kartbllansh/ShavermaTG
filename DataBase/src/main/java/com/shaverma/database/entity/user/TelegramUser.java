package com.shaverma.database.entity.user;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@EqualsAndHashCode(exclude = "id")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TelegramUser")
public class TelegramUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long telegramUserId;

    private String firstName;

    private String lastName;

    private String userName;

}
