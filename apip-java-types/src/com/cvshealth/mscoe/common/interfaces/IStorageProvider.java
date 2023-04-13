package com.cvshealth.mscoe.common.interfaces;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import com.cvshealth.mscoe.common.types.Result;


public interface IStorageProvider<T extends IResource> {
    CompletableFuture<Result<T>> all(IContext context);
    CompletableFuture<Result<T>> create(T entity, IContext context);
    CompletableFuture<Result<T>> delete(UUID id, IContext context);
    CompletableFuture<Result<T>> findById(UUID id, IContext context);
    CompletableFuture<Result<T>> save(UUID id, T entity, IContext context);
}
