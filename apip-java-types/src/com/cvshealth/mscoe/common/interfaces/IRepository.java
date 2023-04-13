package com.cvshealth.mscoe.common.interfaces;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IRepository<T extends IResource> {
    List<T> findAll();
    Optional<T> findById(UUID id);
    T save(T resource);
    void deleteById(UUID id);
}

