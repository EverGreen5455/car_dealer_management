package com.netcracker.server.service.api;

import com.netcracker.server.model.Manager;

import java.util.List;

public interface ManagerService {

    void addManager(Manager manager);

    Manager getManager(Long id);

    void deleteManager(Long id);

    List<Manager> listManagers();

}
