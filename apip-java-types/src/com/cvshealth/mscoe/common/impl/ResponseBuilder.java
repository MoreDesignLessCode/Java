package com.cvshealth.mscoe.common.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cvshealth.mscoe.common.interfaces.IMeta;
import com.cvshealth.mscoe.common.interfaces.IResource;
import com.cvshealth.mscoe.common.types.APIException;
import com.cvshealth.mscoe.common.types.Includes;
import com.cvshealth.mscoe.common.types.Response;


public class ResponseBuilder {
    private Response response;

    public ResponseBuilder(List<IResource> data, APIException errors, IMeta meta, Includes includes) {
        this.response = new Response(data, errors, meta, includes);
    }

    public void setData(List<IResource> value) {
        this.response.setData(value);
    }

    public void setErrors(APIException value) {
        this.response.setErrors(value);
    }

    public void setMeta(IMeta value) {
        this.response.setMeta(value);
    }

    public void setIncludes(Includes value) {
        this.response.setIncludes(value);
    }

    public void addIncludes(String namedKey, IResource value) {
        if (response.getIncludes() == null) {
            response.setIncludes(new Includes());
        }

       // write code to add Includes
    }

    public void appendInclude(String namedKey, IResource value) {
    	
    	// Write code to append include
    }

    public Response build() {
        return this.response;
    }
}
