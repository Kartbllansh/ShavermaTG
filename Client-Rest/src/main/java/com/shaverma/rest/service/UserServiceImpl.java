package com.shaverma.rest.service;

import com.chaverma.dto.UserDTO;
import com.shaverma.database.dao.user.TelegramUserDAO;
import com.shaverma.database.entity.user.TelegramUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.Optional;


/**
 * The type User service.
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final TelegramUserDAO telegramUserDAO;

    @Autowired
    public UserServiceImpl(TelegramUserDAO telegramUserDAO) {
        this.telegramUserDAO = telegramUserDAO;
    }

    /**
     * Method to save to the database. Not safe, since the user may already be created,
     * an exception is thrown ObjectExistException when this script is executed.
     *
     * @param user the user
     * @return long user id
     */
    @Override
    public long saveTelegramUser(UserDTO user) {
        return telegramUserDAO.save(
                toTelegramUserEntity(user)
        ).getId();
    }

    @Override
    public TelegramUser findById(Long id) throws RuntimeException{
        // TODO: Поменять Runtime на свою ошибку
        return telegramUserDAO.findById(id).orElseThrow(() -> new RuntimeException("USer not found with id: " + id));
    }

    private TelegramUser toTelegramUserEntity(UserDTO userDTO){
        return TelegramUser.builder()
                .firstName(userDTO.firstName())
                .lastName(userDTO.lastName())
                .userName(userDTO.username()).build();
    }


}
