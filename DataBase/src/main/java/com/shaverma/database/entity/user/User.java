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
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "telegramUser")
    private TelegramUser telegramUser;
    @OneToOne
    @JoinColumn(name = "webUser")
    private WebUser webUser;
    @OneToOne
    @JoinColumn(name = "appUser")
    private AppUser appUser;
}
