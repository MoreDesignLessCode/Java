package com.cvshealth.mscoe.common.types;

import com.cvshealth.mscoe.common.interfaces.IResource;

import java.util.List;

import com.cvshealth.mscoe.common.interfaces.IMeta;

public class Response {
    private List<IResource> data;
    private APIException exceptions;
    private IMeta meta;
    private Includes includes;

    public Response(List<IResource> data, APIException exceptions, IMeta meta, Includes includes) {
        this.data = data;
        this.exceptions = exceptions;
        this.meta = meta;
        this.includes = includes;
    }

    public List<IResource> getData() {
        return data;
    }

    public void setData(List<IResource> data) {
        this.data = data;
    }

    public APIException getErrors() {
        return exceptions;
    }

    public void setErrors(APIException exceptions) {
        this.exceptions = exceptions;
    }

    public IMeta getMeta() {
        return meta;
    }

    public void setMeta(IMeta meta) {
        this.meta = meta;
    }

    public Includes getIncludes() {
        return includes;
    }

    public void setIncludes(Includes includes) {
        this.includes = includes;
    }
}