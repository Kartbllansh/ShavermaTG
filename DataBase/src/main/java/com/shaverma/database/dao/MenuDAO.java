package com.shaverma.database.dao;

import com.shaverma.database.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuDAO extends JpaRepository<Menu, Long> {
}
