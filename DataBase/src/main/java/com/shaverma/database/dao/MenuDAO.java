package com.shaverma.database.dao;

import com.shaverma.database.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuDAO extends JpaRepository<Menu, Long> {
}
