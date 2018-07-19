package com.netcracker.client;


import com.netcracker.common.Response;
import com.netcracker.server.model.Manager;
import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path(value = "/service")
public interface MainRestService extends RestService {

    @POST
    @Path("/manager")
    @Produces("application/json")
    void addManager(Manager manager, MethodCallback<Response> callback);
}
