package com.shaverma.database.dao.user;

import com.shaverma.database.entity.user.AllUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllUserDAO extends JpaRepository<AllUser, Long> {
}
