package com.shaverma.database.dao.user;


import com.shaverma.database.entity.user.WebUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebUserDAO extends JpaRepository<WebUser, Long> {
}
