package com.netcracker.server.dao;

import com.netcracker.server.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerDAO extends JpaRepository<Manager, Long> {

}
