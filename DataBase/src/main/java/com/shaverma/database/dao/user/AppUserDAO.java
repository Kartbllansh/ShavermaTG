package com.shaverma.database.dao.user;
import com.shaverma.database.entity.user.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserDAO extends JpaRepository<AppUser, Long> {
}
