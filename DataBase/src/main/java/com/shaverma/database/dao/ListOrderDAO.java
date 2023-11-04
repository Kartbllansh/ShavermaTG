package com.shaverma.database.dao;

import com.shaverma.database.entity.ListOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListOrderDAO extends JpaRepository<ListOrder, Long> {
}
