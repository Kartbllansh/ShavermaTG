package com.shaverma.database.dao.user;

import com.shaverma.database.entity.user.TelegramUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelegramUserDAO extends JpaRepository<TelegramUser, Long> {
}
