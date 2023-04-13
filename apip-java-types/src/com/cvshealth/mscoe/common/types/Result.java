package com.cvshealth.mscoe.common.types;

import com.cvshealth.mscoe.common.interfaces.IResource;


public final class Result<T extends IResource> {
    private final String type;
    private final Data<T> data;
    private final APIException exception;

    private Result(String type, Data<T> data, APIException error) {
        this.type = type;
        this.data = data;
        this.exception = error;
    }

    public String getType() {
        return type;
    }

    public Data<T> getData() {
        return data;
    }

    public APIException getError() {
        return exception;
    }

    public static <T extends IResource> Result<T> ok(Data<T> data) {
        return new Result<>("ok", data, null);
    }

    public static <T extends IResource> Result<T> error(APIException error) {
        return new Result<>("error", null, error);
    }
}

