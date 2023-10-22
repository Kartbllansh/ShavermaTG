package com.shaverma.database.dao;

import com.shaverma.database.entity.ListOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ListOrderDAO extends JpaRepository<ListOrder, Long> {
}
