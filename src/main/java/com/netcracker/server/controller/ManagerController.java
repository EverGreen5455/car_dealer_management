package com.netcracker.server.controller;

import com.netcracker.common.RequestStatus;
import com.netcracker.common.Response;
import com.netcracker.server.model.Manager;
import com.netcracker.server.service.api.ManagerService;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
@CommonsLog
public class ManagerController {

    private final ManagerService managerService;

    @Autowired
    public ManagerController(ManagerService managerService) {
        this.managerService = managerService;
    }

    @RequestMapping(value = "/manager", method = RequestMethod.POST)
    @ResponseBody
    public Response addManager(@RequestBody Manager manager) {
        try {
            this.managerService.addManager(manager);
        } catch (IllegalArgumentException e) {
            log.error(e.getMessage());
            return Response.setStatus(RequestStatus.ILLEGAL_ARGUMENT_ERROR);
        }
        return Response.setStatus(RequestStatus.SUCCESS);
    }

    @RequestMapping(value = "/manager", method = RequestMethod.GET)
    @ResponseBody
    @SuppressWarnings("unchecked")
    public Response<ArrayList<Manager>> listManagers() {
        ArrayList<Manager> managers = (ArrayList<Manager>) this.managerService.listManagers();
        if (managers.isEmpty()) {
            return Response.setStatus(RequestStatus.ERROR);
        } else {
            return Response.success().setInfo(managers);
        }
    }

    @RequestMapping(value = "/manager/{id}", method = RequestMethod.GET)
    @ResponseBody
    @SuppressWarnings("unchecked")
    public Response<Manager> getManager(@PathVariable("id") Long id) {
        Manager manager = this.managerService.getManager(id);
        if (manager != null) {
            return Response.success().setInfo(manager);
        } else {
            return Response.setStatus(RequestStatus.USER_NOT_FOUND_ERROR);
        }
    }
}
