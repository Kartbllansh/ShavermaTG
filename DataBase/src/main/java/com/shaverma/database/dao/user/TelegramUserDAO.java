package com.shaverma.database.dao.user;

import com.shaverma.database.entity.user.TelegramUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelegramUserDAO extends JpaRepository<TelegramUser, Long> {
}
