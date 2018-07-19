package com.netcracker.common;

import java.io.Serializable;

public class Response<T extends Serializable> implements Serializable {
    private RequestStatus status;
    private T info;

    private Response(RequestStatus status) {
        this.status = status;
        this.info = null;
    }

    public static Response success() {
        return new Response(RequestStatus.SUCCESS);
    }

    public RequestStatus getStatus() {
        return status;
    }

    public static Response setStatus(RequestStatus status) {
        return new Response(status);
    }

    public T getInfo() {
        return info;
    }

    public Response setInfo(T info) {
        this.info = info;
        return this;
    }

    public boolean isPresent() {
        return info != null;
    }
}

