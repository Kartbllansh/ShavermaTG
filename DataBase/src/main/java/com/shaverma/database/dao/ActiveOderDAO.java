package com.shaverma.database.dao;

import com.shaverma.database.entity.ActiveOrder;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActiveOderDAO extends JpaRepository<ActiveOrder, Long> {
}
