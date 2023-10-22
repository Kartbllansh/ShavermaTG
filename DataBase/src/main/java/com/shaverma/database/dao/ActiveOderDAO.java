package com.shaverma.database.dao;

import com.shaverma.database.entity.ActiveOrder;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ActiveOderDAO extends JpaRepository<ActiveOrder, Long> {
}
