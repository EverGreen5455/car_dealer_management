package com.netcracker.server.service.impl;

import com.netcracker.server.dao.ManagerDAO;
import com.netcracker.server.model.Manager;
import com.netcracker.server.service.api.ManagerService;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@CommonsLog
public class ManagerServiceImpl implements ManagerService {

    private final ManagerDAO managerDAO;

    @Autowired
    public ManagerServiceImpl(ManagerDAO managerDAO) {
        this.managerDAO = managerDAO;
    }

    @Override
    @Transactional
    public void addManager(Manager manager) {
        this.managerDAO.save(manager);
        log.info("save");
    }

    @Override
    @Transactional
    public Manager getManager(Long id) {
        return this.managerDAO.findOne(id);
    }

    @Override
    @Transactional
    public void deleteManager(Long id) {
        this.managerDAO.delete(id);
    }

    @Override
    @Transactional
    public List<Manager> listManagers() {
        return this.managerDAO.findAll();
    }
}
