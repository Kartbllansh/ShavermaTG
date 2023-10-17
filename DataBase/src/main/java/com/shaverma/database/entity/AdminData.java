package com.shaverma.database.entity;

import com.shaverma.database.entity.user.AppUser;
import com.shaverma.database.entity.user.TelegramUser;
import com.shaverma.database.entity.user.WebUser;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode(exclude = "id")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "AppUser")
public class AdminData {
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

    //TODO как составить Admin account, если пользователь может работать и в тг и с сайта
}
