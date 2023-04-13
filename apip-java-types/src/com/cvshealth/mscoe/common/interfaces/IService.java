package com.cvshealth.mscoe.common.interfaces;

import java.util.concurrent.CompletableFuture;

import com.cvshealth.mscoe.common.types.Result;
import com.cvshealth.mscoe.common.types.Uuid;

public interface IService<T extends IResource> {
    CompletableFuture<Result<T>> getById(Uuid id, IContext context);
    CompletableFuture<Result<T>> getCollection(IContext context);
    CompletableFuture<Result<T>> create(T entity, IContext context);
    CompletableFuture<Result<T>> update(Uuid id, T entity, IContext context);
    CompletableFuture<Result<T>> delete(Uuid id, IContext context);
}
