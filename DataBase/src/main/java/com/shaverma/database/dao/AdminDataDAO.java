package com.shaverma.database.dao;

import com.shaverma.database.entity.AdminData;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminDataDAO extends JpaRepository<AdminData, Long> {
}
